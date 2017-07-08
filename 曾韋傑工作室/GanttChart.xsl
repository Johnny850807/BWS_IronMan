<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
        <head>
            <script type="text/javascript" src="http://yourjavascript.com/8514521737/date.js"></script>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script type="text/javascript">
                google.charts.load('current', {'packages':['gantt']});
                google.charts.setOnLoadCallback(drawChart);
                
                function daysToMilliseconds(days) {
                    return days * 24 * 60 * 60 * 1000;
                }

                function getDiffMillisecondsFromTwoDate(date1,date2) {
                    var timeDiff = Math.abs(date2.getTime() - date1.getTime());
                    var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
                    return daysToMilliseconds(diffDays);
                }

                function drawChart() {
                    var date_pattern = 'yyyy d NNN.';
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

                    var options = {
                        height:  rows.length * 60,
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
        </head>
        <body style="background-image: url('http://i.imgur.com/StW51j2.png')">
            <div id="chart_div"></div>
        </body>
    </xsl:template>

    <xsl:template match="Task">
        var startDate = getDateFromFormat('<xsl:value-of select="@StartDate" />',date_pattern);
        var endDate = getDateFromFormat('<xsl:value-of select="@EndDate" />',date_pattern);
         var dependency = '<xsl:value-of select="@Dependency" />';
        if (dependency.length == 0)
            dependency = null;
        rows.push(['<xsl:value-of select="@name" />', '<xsl:value-of select="@name" />', '<xsl:value-of select="parent::*/@name" />',
                          startDate  , endDate  , daysToMilliseconds(startDate,endDate) , 100, dependency ]);
    </xsl:template>

</xsl:stylesheet>