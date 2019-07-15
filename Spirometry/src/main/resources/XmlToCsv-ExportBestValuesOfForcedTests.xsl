<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text>Patient ID:;</xsl:text>
    <xsl:text>Test Type:;</xsl:text>
    <xsl:text>Test Date:;</xsl:text>
    <xsl:text>VCmax:;</xsl:text>
    <xsl:text>Pre FEV1:;</xsl:text>
    <xsl:text>Post FEV1:;</xsl:text>
    <xsl:text>Pre FVC:;</xsl:text>
    <xsl:text>Post FVC:;</xsl:text>
    <xsl:text>Lung age:; &#13;&#10;</xsl:text>
    
    
    <!-- create a row for each test session-->
    <xsl:for-each select="//Intervals/Interval[Tests/Test/@TypeOfTest='FVC' or Tests/Test/@TypeOfTest='FVL']">
      <!--<xsl:text>Patient ID:</xsl:text>-->
      <xsl:value-of select="../../@ID"/>
      <xsl:text>;</xsl:text>

      <!--<xsl:text> Test Type:</xsl:text>-->
      <xsl:value-of select="Tests/Test[1]/@TypeOfTest"/>
      <xsl:text>;</xsl:text>

      <!--<xsl:text> Test Date:</xsl:text>-->
      <xsl:value-of select="Tests/Test[1]/TestDate"/>
      <xsl:text>;</xsl:text>

      <!--<xsl:text> VCmax:</xsl:text>-->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='VCmax']/DataValue"/>
      <xsl:text>;</xsl:text>

      <!--<xsl:text> FEV1:</xsl:text>-->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FEV1']/DataValue"/>
      <xsl:text>;</xsl:text>

      <!--<xsl:text> Post FEV1:</xsl:text>-->
      <xsl:value-of select="Tests/Test[@StageType='Post']/BestValues/ResultParameter[@ID='FEV1']/DataValue"/>
      <xsl:text>;</xsl:text>


      <!--<xsl:text> FVC:</xsl:text>-->
      <xsl:value-of select="Tests/Test[1]/BestValues/ResultParameter[@ID='FVC']/DataValue"/>
      <xsl:text>;</xsl:text>

      <!--<xsl:text> Post FVC:</xsl:text>-->
      <xsl:value-of select="Tests/Test[@StageType='Post']/BestValues/ResultParameter[@ID='FVC']/DataValue"/>
      <xsl:text>;</xsl:text>

      <!--<xsl:text> Lung age:</xsl:text>-->
      <xsl:value-of select="LungAge"/>
      <xsl:text>; &#13;&#10;</xsl:text> <!-- add carriag return => new line -->
    </xsl:for-each>

    <!--Add Summary report-->
    <xsl:text>nr. of patients: </xsl:text>
    <xsl:variable name="NumberOfPatients" select="//Patients/Patient"/>
    <xsl:text>;</xsl:text>
    <xsl:value-of select="count($NumberOfPatients)"/>
    <xsl:text>;&#13;&#10;</xsl:text>



    <xsl:text>nr. of test sessions: </xsl:text>
    <xsl:text>;</xsl:text>
    <xsl:variable name="NumberOfIntervals" select="//Patients/Patient/Intervals/Interval"/>
    <xsl:value-of select="count($NumberOfIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of FVC sessions: </xsl:text>
    <xsl:text>;</xsl:text>
    <xsl:variable name="NumberOfFVCIntervals" select="//Patients/Patient/Intervals/Interval[Tests/Test[@TypeOfTest='FVC']]"/>
    <xsl:value-of select="count($NumberOfFVCIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of FVC trials: </xsl:text>
    <xsl:text>;</xsl:text>
    <xsl:variable name="NumberOfFVCTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FVC']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfFVCTrials)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of FVL sessions: </xsl:text>
    <xsl:text>;</xsl:text>
    <xsl:variable name="NumberOfFVLIntervals" select="//Patients/Patient/Intervals/Interval[Tests/Test[@TypeOfTest='FVL']]"/>
    <xsl:value-of select="count($NumberOfFVLIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of FVL trials: </xsl:text>
    <xsl:text>;</xsl:text>
    <xsl:variable name="NumberOfFVLTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FVL']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfFVLTrials)"/>
    <xsl:text>&#13;&#10;</xsl:text>




  </xsl:template>
</xsl:stylesheet>
