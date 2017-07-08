<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
        <head>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">
            </script>
            <script type="text/javascript">
                google.charts.load('current', { packages: ["orgchart"] });
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {
                        var data = new google.visualization.DataTable();
                        data.addColumn('string', 'Title');
                        data.addColumn('string', 'Manager');
                        data.addColumn('string', 'Description');

                        var rows = [];
                        <xsl:apply-templates/>
                        data.addRows(rows);

                        var chart = new google.visualization.OrgChart(document.getElementById('chart_div'));
                        chart.draw(data, { allowHtml: true });
                    }
            </script>
        </head>
        <body style="background-image: url('http://i.imgur.com/StW51j2.png')">
            <div id="chart_div">
            </div>
        </body>
    </xsl:template>
    <xsl:template match="TaskGroup">
        rows.push(['<xsl:value-of select="@name" />','<xsl:value-of select="parent::*/@name" />','']);
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="Task">
        rows.push(['<xsl:value-of select="@name" />','<xsl:value-of select="parent::*/@name" />','<xsl:value-of select="@Description" />']);
    </xsl:template>

</xsl:stylesheet>