<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:param name="ColumnSeparator" select="','" />

  <xsl:param name="DateFormat"      select="'[Y0001]-[M01]-[D01]'" />

  <xsl:param name="TimeFormat"      select="'[H01]:[m01]:[s01]'" />


  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text>Patient ID:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>Last name:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>First name:</xsl:text>
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
    <xsl:text> Number of accepted trials:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Predicted FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> LLN FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Best FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Predicted FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> LLN FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Best FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial1 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial1 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial1 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial2 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial2 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial2 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial3 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial3 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial3 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial4 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial4 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial4 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial5 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial5 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial5 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial6 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial6 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial6 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial7 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial7 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial7 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial8 FEV1:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial8 FVC:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:text> Trial8 Accepted:</xsl:text>
    <xsl:value-of select="$ColumnSeparator"/> 
    <xsl:text>&#13;&#10;</xsl:text>


    <!-- create a row for each test session-->
    <xsl:for-each select="//Intervals/Interval/Tests/Test[@TypeOfTest='FVC' or @TypeOfTest='FVL']">
      <!-- Patient ID: -->
      <xsl:value-of select="../../../../@ID"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- Last Name: -->
      <xsl:value-of select="../../../../LastName"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- First Name: -->
      <xsl:value-of select="../../../../FirstName"/>
      <xsl:value-of select="$ColumnSeparator"/>
      
      <!--  Test Type: -->
      <xsl:value-of select="@TypeOfTest"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Test Date: -->
      <xsl:variable name="testtime"
                   select="TestDate" />
      <!--  Test Date: -->
      <xsl:value-of select="format-dateTime($testtime, $DateFormat, 'en', (), ())" />

      <xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="format-dateTime($testtime, $TimeFormat, 'en', (), ())" />

      <xsl:value-of select="$ColumnSeparator"/>


      <!--  DOB: -->
      <xsl:value-of select="PatientDataAtTestTime/DateOfBirth"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Gender: -->
      <xsl:value-of select="PatientDataAtTestTime/Gender"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Height: -->
      <xsl:value-of select="PatientDataAtTestTime/Height"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!--  Weight: -->
      <xsl:value-of select="PatientDataAtTestTime/Weight"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- == Reported / Best == -->      
      
      <!-- count accepted trials: -->
      <xsl:value-of select="count(Trials/Trial[Accepted='true'])"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- reported / Best values (only when accepted trials)-->
      <xsl:choose>
        <xsl:when test="count(Trials/Trial[Accepted='true'])>0">
          
          <!--  FEV1: -->
          <xsl:value-of select="BestValues/ResultParameter[@ID='FEV1']/PredictedValue"/>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="BestValues/ResultParameter[@ID='FEV1']/LLNormalValue"/>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="BestValues/ResultParameter[@ID='FEV1']/DataValue"/>
          <xsl:value-of select="$ColumnSeparator"/>

          <!--  FVC: -->
          <xsl:value-of select="BestValues/ResultParameter[@ID='FVC']/PredictedValue"/>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="BestValues/ResultParameter[@ID='FVC']/LLNormalValue"/>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="BestValues/ResultParameter[@ID='FVC']/DataValue"/>
          <xsl:value-of select="$ColumnSeparator"/>
          
        </xsl:when>
        <xsl:otherwise>
          
          <!--  FEV1: -->
          <xsl:text></xsl:text>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="$ColumnSeparator"/>
          
          <!--  FVC: -->
          <xsl:text></xsl:text>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="$ColumnSeparator"/>
          <xsl:value-of select="$ColumnSeparator"/>
          
        </xsl:otherwise>
      </xsl:choose>
      
      <!-- == loop trials == -->

      <xsl:for-each select="Trials/Trial">
        
        <!--  FEV1: -->
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1']/DataValue"/>
        <xsl:value-of select="$ColumnSeparator"/>

        <!--  FVC: -->
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FVC']/DataValue"/>
        <xsl:value-of select="$ColumnSeparator"/>

        <!--  accepted: -->
        <xsl:value-of select="Accepted"/>
        <xsl:value-of select="$ColumnSeparator"/>
        
      </xsl:for-each>
      
     
      <!--  new line -->
      <xsl:text>&#13;&#10;</xsl:text>
    </xsl:for-each>

    <!--Add Summary report-->
    <xsl:text>nr. of patients: </xsl:text>
    <xsl:variable name="NumberOfPatients" select="//Patients/Patient"/>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:value-of select="count($NumberOfPatients)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of test sessions: </xsl:text>
    <xsl:variable name="NumberOfIntervals" select="//Patients/Patient/Intervals/Interval"/>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:value-of select="count($NumberOfIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of DLCO tests: </xsl:text>
    <xsl:variable name="NumberOfDlcoTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='DLCO' and position() = last()]"/>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:value-of select="count($NumberOfDlcoTests)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of FVC tests: </xsl:text>
    <xsl:variable name="NumberOfFVCTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FVC' and position() = last()]"/>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:value-of select="count($NumberOfFVCTests)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of FVL tests: </xsl:text>
    <xsl:variable name="NumberOfFVLTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FVL' and position() = last()]"/>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:value-of select="count($NumberOfFVLTests)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of SVC tests: </xsl:text>
    <xsl:variable name="NumberOfSVCTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='SVC' and position() = last()]"/>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:value-of select="count($NumberOfSVCTests)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of MVV tests: </xsl:text>
    <xsl:variable name="NumberOfMVVTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='MVV' and position() = last()]"/>
    <xsl:value-of select="$ColumnSeparator"/>
    <xsl:value-of select="count($NumberOfMVVTests)"/>
    <xsl:text>&#13;&#10;</xsl:text>
  </xsl:template>
</xsl:stylesheet>
