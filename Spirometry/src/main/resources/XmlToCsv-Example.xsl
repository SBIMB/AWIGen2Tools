<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:param name="ColumnSeparator"
             select="','" />

  <xsl:param name="DateFormat"
             select="'[Y0001]-[M01]-[D01]'" />

  <xsl:param name="TimeFormat"
             select="'[H01]:[m01]:[s01]'" />

  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text> Patient ID:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> DOB:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Lastname:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Firstname:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Gender:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Height:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Weight:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Test Date:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Test Time:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trials accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Total Trials:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEV0.75:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEV0.5:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEV1/FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> PEF:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEF25:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEF50:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEF75:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FEF25-75:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> FET:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <!-- new line -->
    <xsl:text>&#13;&#10;</xsl:text>


    <!-- create a row for each test session-->
    <xsl:for-each select="//Intervals/Interval[count(Tests/Test[1]/Trials/Trial[Accepted='true'])>0]">
      <!--<xsl:for-each select="//Intervals/Interval/Trials/Trial[Accepted='true']/../..">-->
      <!--Patient ID: -->
      <xsl:value-of select="../../@ID"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--Date of Birth: -->
      <xsl:value-of select="Tests/Test[1]/PatientDataAtTestTime/DateOfBirth"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--lastname: -->
      <xsl:value-of select="../../LastName"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--firstname: -->
      <xsl:value-of select="../../FirstName"/>
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

      <!--  Test Date: -->
      <xsl:variable as="xs:dateTime" name="testtime"
                   select="Tests/Test[1]/TestDate" />
      <!--  Test Date: -->
      <xsl:value-of select="format-date($testtime, $DateFormat)" />
      <xsl:value-of select="$ColumnSeparator"/>

      <xsl:value-of select="format-time($testtime, $TimeFormat)" />
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- trials accepted -->
      <xsl:variable name="NumberOfAcceptedTrials" select="Tests/Test[1]/Trials/Trial[Accepted='true']"/>
      <xsl:value-of select="count($NumberOfAcceptedTrials)"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- total trials attempted -->
      <xsl:variable name="NumberOfTrials" select="Tests/Test[1]/Trials/Trial"/>
      <xsl:value-of select="count($NumberOfTrials)"/>
      <xsl:value-of select="$ColumnSeparator"/>


      <!-- FVC: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEV1: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEV1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEV0.75: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEV_75']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEV0.5: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEV_5']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEV1/FVC: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEV1_FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>
      <!-- the column separator used here is ';'-->

      <!-- PEF: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='PEF']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEF25: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEF25']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEF50: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEF50']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEF75: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEF75']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FEF25-75: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEF2575']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- FET: -->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FET']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- comment: -->
      <xsl:value-of select="translate(Reviewers/Reviewer[1]/Comment, '&#13;&#10;', '^')"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- new line -->
      <xsl:text>&#13;&#10;</xsl:text>
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

    <xsl:text>;
</xsl:text>

  </xsl:template>
</xsl:stylesheet>
