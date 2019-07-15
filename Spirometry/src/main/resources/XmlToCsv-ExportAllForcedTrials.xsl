<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text>Patient ID,</xsl:text>
    <xsl:text>Date,</xsl:text>
    <xsl:text>Trial #,</xsl:text>
    <xsl:text>Test Type,</xsl:text>
    <xsl:text>FVC,</xsl:text>
    <xsl:text>FVC Pred,</xsl:text>
    <xsl:text>PEF:,</xsl:text>
    <xsl:text>PEF Pred,</xsl:text>
    <xsl:text>FEV.25,</xsl:text>
    <xsl:text>FEV.25 Pred,</xsl:text>
    <xsl:text>FEV.5,</xsl:text>
    <xsl:text>FEV.5 PRED,</xsl:text>
    <xsl:text>FEV.75,</xsl:text>
    <xsl:text>FEV.75 PRED,</xsl:text>
    <xsl:text>FEV1,</xsl:text>
    <xsl:text>FEV1 PRED,</xsl:text>
    <xsl:text>FEF25-75%,</xsl:text>
    <xsl:text>FEF25-75% PRED,</xsl:text>
    <xsl:text>FEV.5/FVC,</xsl:text>
    <xsl:text>FEV.5/FVC PRED,</xsl:text>
    <xsl:text>FEV1/FVC,</xsl:text>
    <xsl:text>FEV1/FVC PRED,</xsl:text>
    <xsl:text>&#13;&#10;</xsl:text>
    
    
    <!-- create a row for each test session-->
    <xsl:for-each select="//Intervals/Interval/Tests/Test[@TypeOfTest='FVC' or @TypeOfTest='FVL']/Trials/Trial">
      
      <!-- Patient ID -->
      <xsl:value-of select="../../../../../../@ID"/>
      <xsl:text>,</xsl:text>

      <!-- Date -->
      <xsl:value-of select="Date"/>
      <xsl:text>,</xsl:text>

      <!-- Trial # -->
      <xsl:value-of select="Number"/>
      <xsl:text>,</xsl:text>
      
      <!-- Test Type-->
      <xsl:value-of select="../..//@TypeOfTest"/>
      <xsl:text>,</xsl:text>

      <!-- FVC -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FVC']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FVC Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FVC']/PredictedValue"/>
      <xsl:text>,</xsl:text>


      <!-- PEF -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PEF']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- PEF Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PEF']/PredictedValue"/>
      <xsl:text>,</xsl:text>


      <!-- FEV.25 -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_25']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FEV.25 Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_25']/PredictedValue"/>
      <xsl:text>,</xsl:text>


      <!-- FEV.5 -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_5']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FEV.5 Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_5']/PredictedValue"/>
      <xsl:text>,</xsl:text>


      <!-- FEV.75 -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_75']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FEV.75 Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_75']/PredictedValue"/>
      <xsl:text>,</xsl:text>


      <!-- FEV1 -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FEV1 Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1']/PredictedValue"/>
      <xsl:text>,</xsl:text>


      <!-- FEF25-75% -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF2575']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FEF25-75% Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF2575']/PredictedValue"/>
      <xsl:text>,</xsl:text>
      

      <!-- FEV.5/FVC -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_5_FVC']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FEV.5/FVC Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_5_FVC']/PredictedValue"/>
      <xsl:text>,</xsl:text>      
      

      <!-- FEV1/FVC -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_FVC']/DataValue"/>
      <xsl:text>,</xsl:text>

      <!-- FEV1/FVC Predicted -->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_FVC']/PredictedValue"/>
      <xsl:text>,</xsl:text>

      <!-- new line for next trial -->
      <xsl:text>&#13;&#10;</xsl:text>
     
    </xsl:for-each>

    <!--Add Summary report-->
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of patients: </xsl:text>
    <xsl:variable name="NumberOfPatients" select="//Patients/Patient"/>
    <xsl:value-of select="count($NumberOfPatients)"/>
    <xsl:text>,&#13;&#10;</xsl:text>
    <xsl:text>nr. of test sessions: </xsl:text>
    <xsl:variable name="NumberOfIntervals" select="//Patients/Patient/Intervals/Interval"/>
    <xsl:value-of select="count($NumberOfIntervals)"/>
    <xsl:text>,&#13;&#10;</xsl:text>
    <xsl:text>nr. of tests (pre and post): </xsl:text>
    <xsl:variable name="NumberOfTests" select="//Patients/Patient/Intervals/Interval/Tests/Test"/>
    <xsl:value-of select="count($NumberOfTests)"/>
    <xsl:text>,&#13;&#10;</xsl:text>
    <xsl:text>nr. of trials: </xsl:text>
    <xsl:variable name="NumberOfTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfTrials)"/>


  </xsl:template>
</xsl:stylesheet>
