<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet
  version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Pharmacy</title>
      </head>
      <body>
        <h2> Welcome to Pharmacy!</h2>
        <table border="1">
          <tr bgcolor="#9acd32">
            <th>name</th>
            <th>pharm</th>
            <th>price</th>
            <th>analogs</th>
          </tr>
          <xsl:for-each select="Medicine/drug">
            <tr>
             <td> <xsl:apply-templates select="name"/> </td>
              <td> <xsl:apply-templates select="pharm" /> </td>
              <td> <xsl:value-of select="@price" /> </td>
              <td> <xsl:apply-templates select="analogs" /> </td>
              </tr>
          </xsl:for-each>
          </table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="text()">
   <span style="color:#ff0000">
    <xsl:value-of select="."/>
     </span>
  </xsl:template>
  
</xsl:stylesheet>