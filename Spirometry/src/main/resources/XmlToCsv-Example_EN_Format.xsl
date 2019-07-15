<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:param name="ColumnSeparator" select="';'" />

  <xsl:param name="DateFormat"      select="'[Y0001]-[M01]-[D01]'" />

  <xsl:param name="TimeFormat"      select="'[H01]:[m01]:[s01]'" />


  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text>Patient ID:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Test Type:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Test Date:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Test Time:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> DOB:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Gender:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Height:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Weight:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> VCmax:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Pre FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Post FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Pre FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Post FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> TLCO [mmol/min/kPa]:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>&#13;&#10;</xsl:text>


    <!-- create a row for each test session-->
    <xsl:for-each select="//Intervals/Interval">
      <!-- Patient ID: -->
      <xsl:value-of select="../../@ID"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Test Type: -->
      <xsl:value-of select="Tests/Test[1]/@TypeOfTest"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Test Date: -->
      <xsl:variable name="testtime"
                   select="Tests/Test[1]/TestDate"/>
      <!--  Test Date: 
      <xsl:value-of select="java:format(java:java.text.SimpleDateFormat.new('yyyy.MM.dd'), java:java.text.SimpleDateFormat.)"/>-->
	  <xsl:value-of select="concat(substring-before($testtime,'T'))"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- <xsl:value-of select="format-dateTime($testtime, $TimeFormat, 'en','','')"/> -->
	  <xsl:value-of select="substring($testtime,12,8)"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  DOB: -->
      <xsl:value-of select="Tests/Test[1]/PatientDataAtTestTime/DateOfBirth"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Gender: -->
      <xsl:value-of select="Tests/Test[1]/PatientDataAtTestTime/Gender"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Height: -->
      <xsl:value-of select="Tests/Test[1]/PatientDataAtTestTime/Height"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Weight: -->
      <xsl:value-of select="Tests/Test[1]/PatientDataAtTestTime/Weight"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  VCmax: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='VCmax']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  FEV1: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEV1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Post FEV1: -->
      <xsl:value-of select="Tests/Test[2]/BestValues/ResultParameter[@ID='FEV1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>


      <!--  FVC: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Post FVC: -->
      <xsl:value-of select="Tests/Test[last()]/BestValues/ResultParameter[@ID='FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  TLCO: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='TLCO']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>
      <!--  new line -->
      <xsl:text>;&#13;&#10;</xsl:text>
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
