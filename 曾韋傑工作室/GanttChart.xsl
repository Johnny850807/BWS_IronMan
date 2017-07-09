<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
        <head>
            <script type="text/javascript" src="http://waterball.tk:8080/TriMago/date.js"></script>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script type="text/javascript">
                google.charts.load('current', {'packages':['gantt']});
                google.charts.setOnLoadCallback(drawChart);
                
                function daysToMilliseconds(days) {
                    return days * 24 * 60 * 60 * 1000;
                }

                function getDiffMillisecondsFromTwoDate(date1,date2) {
                    return daysToMilliseconds(getDiffDaysFromTwoDate(date1,date2));
                }

                function getDiffDaysFromTwoDate(date1,date2) {
                    var timeDiff = Math.abs(date2.getTime() - date1.getTime());
                    var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
                    return diffDays;
                }

                function drawChart() {
                    var date_pattern = 'yyyy d NNN.';
                    var earliestDate = getDateFromFormat("5000 1 Jan.",date_pattern);
                    var largestDate = getDateFromFormat("1997 1 Jan.",date_pattern);
                    var data = new google.visualization.DataTable();
                    data.addColumn('string', 'Task ID');
                    data.addColumn('string', 'Task Name');
                    data.addColumn('string', 'Resource');
                    data.addColumn('date', 'Start Date');
                    data.addColumn('date', 'End Date');
                    data.addColumn('number', 'Duration');
                    data.addColumn('number', 'Percent Complete');
                    data.addColumn('string', 'Dependencies');

                    var rows = [];
                    <xsl:apply-templates select="//Task"/>
                    
                    data.addRows(rows);
                    var garttWidth = 154 + getDiffDaysFromTwoDate(earliestDate,largestDate) * 10;
                    var options = {
                        height:  rows.length * 60,
                        width: garttWidth,
                        gantt: {
                            innerGridHorizLine: {
                                strokeWidth: 2
                            },
                        },
                        backgroundColor: {fill: '#F8F9FA'}
                    };

                    var chart = new google.visualization.Gantt(document.getElementById('chart_div'));

                    chart.draw(data, options);
                }
            </script>
			<style>
			body{
				background-color:'#01190C';
			}
			</style>
        </head>
        <body>
            <div id="chart_div"></div>
        </body>
    </xsl:template>

    <xsl:template match="Task">
        var startDate = getDateFromFormat('<xsl:value-of select="@StartDate" />',date_pattern);
        var endDate = getDateFromFormat('<xsl:value-of select="@EndDate" />',date_pattern);
         var dependency = '<xsl:value-of select="@Dependency" />';
        if (dependency.length == 0)
            dependency = null;
        if (compareTwoDates(largestDate,endDate) == -1)
            largestDate = endDate;
        if (compareTwoDates(earliestDate,startDate) == 1)
            earliestDate = startDate;
            
        rows.push(['<xsl:value-of select="@name" />', '<xsl:value-of select="@name" />', '<xsl:value-of select="parent::*/@name" />',
                          startDate  , endDate  , daysToMilliseconds(startDate,endDate) , 100, dependency ]);
    </xsl:template>

</xsl:stylesheet>