<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:param name="ColumnSeparator"
             select="';'" />
  <xsl:param name="LineSeparator"
               select="'&#13;&#10;'" />
  
  <xsl:param name="DateFormat"
             select="'[Y0001]-[M01]-[D01]'" />

  <xsl:param name="TimeFormat"
             select="'[H01]:[m01]:[s01]'" />


  <xsl:template name="output-tokens">
    <xsl:param name="list" />
    <xsl:variable name="newlist" select="concat(normalize-space($list), ' ')" />
    <xsl:variable name="first" select="substring-before($newlist, ' ')" />
    <xsl:variable name="remaining" select="substring-after($newlist, ' ')" />
    <id>
      <xsl:value-of select="$first" />
    </id>
    <xsl:if test="$remaining">
      <xsl:call-template name="output-tokens">
        <xsl:with-param name="list" select="$remaining" />
      </xsl:call-template>
    </xsl:if>
  </xsl:template>
  
  <xsl:template match="/">
    <!-- Title (first row) -->
    <!-- empty in this example-->

    <!-- create a new row for each trial-->
    <xsl:for-each select="//Intervals/Interval/Tests/Test/Trials/Trial">

      <!-- Patient ID -->
      <xsl:text>Patient ID: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="../../../../../../@ID"/>
      <xsl:value-of select="$LineSeparator"/>

      <!-- Date -->
      <!--
      <xsl:value-of select="Date"/>
      <xsl:text>;</xsl:text>
      -->
      <!-- split date and time -->
      <!--  Test Date: -->
      <xsl:variable name="testtime" select="Date"/>
      
      <!--  Test Date: -->
      <xsl:text>Test Date: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="format-dateTime($testtime, $DateFormat, 'en', (), ())" />
      <xsl:value-of select="$LineSeparator"/>
      
      <!--  Test Time: -->
      <xsl:text>Test Time: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="format-dateTime($testtime, $TimeFormat, 'en', (), ())" />
      <xsl:value-of select="$LineSeparator"/>
      
      <!-- Trial # -->
      <xsl:text>Trial Number: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="Number"/>
      <xsl:value-of select="$LineSeparator"/>

      <!-- Test Type-->
      <xsl:text>Test Type: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="../..//@TypeOfTest"/>
      <xsl:value-of select="$LineSeparator"/>

      <!-- Accepted -->
      <xsl:text>Accepted: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="Accepted"/>
      <xsl:value-of select="$LineSeparator"/>

      <!-- Flow Data -->
      <xsl:text>Flow Data ---</xsl:text>
      <xsl:value-of select="$LineSeparator"/>
      
      <xsl:text>TimeZeroOffset: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ChannelFlow/TimeZeroOffset"/>
      <xsl:value-of select="$LineSeparator"/>

      <xsl:for-each select="ChannelFlow/SamplingValues">
        <xsl:value-of select=" replace(current(),' ',$ColumnSeparator)"/>
      </xsl:for-each>
      <xsl:value-of select="$LineSeparator"/>

      <!-- Volume Data -->
      <xsl:text>Volume Data ---</xsl:text>
      <xsl:value-of select="$LineSeparator"/>

      <xsl:text>TimeZeroOffset: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ChannelVolume/TimeZeroOffset"/>
      <xsl:value-of select="$LineSeparator"/>

      <xsl:text>DefaultVTPlotDrawEndIdx: </xsl:text>
      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ChannelVolume/DefaultVTPlotDrawEndIdx"/>
      <xsl:value-of select="$LineSeparator"/>
      
      <xsl:for-each select="ChannelVolume/SamplingValues">
        <xsl:value-of select=" replace(current(),' ',$ColumnSeparator)"/>
      </xsl:for-each>
      <xsl:value-of select="$LineSeparator"/>
      
      
      <!--  new line -->
      <xsl:value-of select="$LineSeparator"/>
    </xsl:for-each>

    <!--Add Summary report-->
    <xsl:text>nr. of patients: </xsl:text>
    <xsl:variable name="NumberOfPatients" select="//Patients/Patient"/>
    <xsl:value-of select="count($NumberOfPatients)"/>
    <xsl:text>;&#13;&#10;</xsl:text>
    <xsl:text>nr. of test sessions: </xsl:text>
    <xsl:variable name="NumberOfIntervals" select="//Patients/Patient/Intervals/Interval"/>
    <xsl:value-of select="count($NumberOfIntervals)"/>
    <xsl:text>;&#13;&#10;</xsl:text>
    <xsl:text>nr. of DLCO tests: </xsl:text>
    <xsl:variable name="NumberOfDlcoTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='DLCO' and position() = last()]"/>
    <xsl:value-of select="count($NumberOfDlcoTests)"/>
    <xsl:text>;
</xsl:text>

  </xsl:template>
</xsl:stylesheet>
