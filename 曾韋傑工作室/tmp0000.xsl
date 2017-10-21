<?xml version="1.0"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <head>
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script type="text/javascript">
                google.charts.load('current', { packages: ["orgchart"] });
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {
                        var data = new google.visualization.DataTable();
                        data.addColumn('string', 'Name');
                        data.addColumn('string', 'Parent');
                        data.addColumn('string', 'Description');

                        var rows = [];
                                        
                <xsl:apply-templates/>
                        data.addRows(rows);

                        var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
                        chart.draw(data, { allowHtml: true });
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
    <xsl:template match="TaskGroup">
            rows.push([{v:'<xsl:value-of select="@Name" />', f:'<p style="color:blue; font-style:bold; font-size:17"><xsl:value-of select="@Name" /></p>'},
        '<xsl:value-of select="parent::*/@Name" />',
        '']);
                
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="Task">
        <xsl:variable name="imgUrl" select='@AssignedUserImageUrl'/>
        rows.push([{v:'<xsl:value-of select="@Name" />', f:'<p style="color:black; font-size:14"><xsl:value-of select="@Name" /></p>
        <xsl:if test="@Status = 'assigned' or @Status = 'pass' or @Status = 'pending' or @Status = 'doing'">
            <img style="width:38px; height:38px;" class="w3-circle" src="$imgUrl"/>
        </xsl:if>
        <xsl:choose>
            <xsl:when test="@Status = 'assigned'">
                <p style="color:red; font-style:italic; font-size:14;">Assigned</p>
            </xsl:when>
            <xsl:when test="@Status = 'pass'">
                <p style="color:Green; font-style:italic; font-size:14;">Pass</p>
            </xsl:when>
            <xsl:when test="@Status = 'pending'">
                <p style="color:blue; font-style:bold; font-size:14;">Pending</p>
            </xsl:when>
            <xsl:when test="@Status = 'doing'">
                <p style="color:yellow; font-style:italic; font-size:14;">Doing</p>
            </xsl:when>
            <xsl:otherwise>
                <p style="color:gray; font-style:italic; font-size:14;">None</p>
            </xsl:otherwise>
        </xsl:choose>'},
        '<xsl:value-of select="parent::*/@Name" />',
        '<xsl:value-of select="@Description" />']);
        
    </xsl:template>
</xsl:stylesheet>