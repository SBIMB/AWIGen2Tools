<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:param name="ColumnSeparator" select="';'" /> <!-- this needs to be changed, depending on your regional setting e.g. to ','-->

  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text>Patient ID</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>LastName</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FirstName</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Gender</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DateOfBirth</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Height</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Weight</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Ethnicity</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />

    <xsl:text>Test Type</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Test Date</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Sequence in session</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />

    <xsl:text>Trial Nr</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>NumOfTrials</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>TrialAccepted</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>TrialAccepted by System</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Trial Rank</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>TrialRank by System</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />

    <xsl:text>DeviceSerNr</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />

    <xsl:text>QualityGrade</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>QualityGrade by System</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <!--
    <xsl:text>Systeminterpretation</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>SysteminterpretationOriginal</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    -->


    <xsl:text>Amb. Humidity</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Amb. Pressure</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Amb. Temperature</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Amb. Temperature Far</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>ATI</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>BEV</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>BHT</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>BTPSex</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>BTPSin</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>CEV</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>COHb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>ColBar Vol</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>CO Conc</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>HE Conc</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Sim CO Conc</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Sim CO2 Conc</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Sim HE Conc</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Sim O2 Conc</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>O2 Conc</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>CVI</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Anat Dead Space</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Syst Dead Space</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Discard Vol</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLadj</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLadj</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLadj/VA</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLadj/VA</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLCO</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLCO</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLCO/VA (KCO)</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>DLCO/VA (KCO)</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>E50/I50</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>EOTV</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>ERV</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FA CO</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FA HE</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FE CO</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF10</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF25%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF25-75%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF2575/FVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF25-75% (FVC6)</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF40%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF50%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF50/FVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF50/VCmax</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF60%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF75%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF75-85%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEF80%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FET</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FET25-75%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV.25</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV.5</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV.5/FVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV.75</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV.75/FEV6</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV.75/FVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV.75/VCmax</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV1</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV1/FEV6</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV1/FIV1</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV1/FVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV1/FVC6</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV1/VCmax</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV1/VCext</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV3</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV3/FVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV3/VCmax</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FEV6</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FI CO</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIF25%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIF50%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIF50/FEF50</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIF75%</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FI HE</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIV.25</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIV.5</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIV1</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FIVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FRC sb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FRC base</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FRC sb Cor</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FRC extrapol</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FRC mb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>f</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FVC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>FVC6</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Hb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Hb [g/dl]</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>IC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>tI</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>IRV</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Kroghs K</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>LCI</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MEF20</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MEF25</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MEF40</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MEF50</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MEF60</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MEF75</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MEF90</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MIF25</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MIF50</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MIF75</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MMEF</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>M0</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MR1</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MR2</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Message No.</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MTC1</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MTC2</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MTC3</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MTCR</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MVV</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MVV6</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>MVV time</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>PAO2</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>PAO2 [mmHg]</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>PEF</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>PEF [L/min]</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>PEFT</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>PIF</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>PIF</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Rf</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>RV sb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>RV sb cor</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>RV mb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>RV/TLC sb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>RV/TLC sb Cor</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>RV/TLC mb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>STPD</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Syringe Volume</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>t0</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>TLC mb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>TLC sb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>TLC sb Cor</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>TLCO</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VA sb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VA sb Cor</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VA mb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VC</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VCex</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VCext</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VCin</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VCmax</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>Vd</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VI</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VT</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VT/FRC mb</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:text>VT/kg</xsl:text>
    <xsl:value-of select="$ColumnSeparator" />

    <!-- add carriag return => new line -->
    <xsl:text>&#13;&#10;</xsl:text>
    
    
    <!-- create a row for each trial-->
    <xsl:for-each select="//Intervals/Interval/Tests/Test/Trials/Trial">

      <!-- == Patient Information == -->
      <!-- Patient ID -->
      <xsl:value-of select="../../../../../../@ID"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../../../../../LastName"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../../../../../FirstName"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../PatientDataAtTestTime/Gender"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../PatientDataAtTestTime/DateOfBirth"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../PatientDataAtTestTime/Height"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../PatientDataAtTestTime/Weight"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../PatientDataAtTestTime/Ethnicity"/>
      <xsl:value-of select="$ColumnSeparator" />     
      <!-- == Trial/Test Information == -->
      
      <!-- Test Type-->
      <xsl:value-of select="../..//@TypeOfTest"/>
      <xsl:value-of select="$ColumnSeparator" />

      <!-- Date -->
      <xsl:value-of select="Date"/>
      <xsl:value-of select="$ColumnSeparator" />

      <!-- index of test: 1: pre; 2: post -->
      <xsl:value-of select="count(../../preceding-sibling::Test)+1" />
      <xsl:value-of select="$ColumnSeparator" />
      
      <xsl:value-of select="Number"/>
      <xsl:value-of select="$ColumnSeparator" />
      
      <!-- count number of trials-->
      <xsl:variable name="NumberOfTrials" select="../Trial"/>
      <xsl:value-of select="count($NumberOfTrials)"/>
      <xsl:value-of select="$ColumnSeparator" />
      
      <!-- Accepted -->      
      <xsl:value-of select="Accepted"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="AcceptedOriginal"/>
      <xsl:value-of select="$ColumnSeparator" />
      
      <xsl:value-of select="Rank"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="RankOriginal"/>
      <xsl:value-of select="$ColumnSeparator" />

      <!-- = Test Information = -->
      <xsl:value-of select="../../Device/SerialNumber"/>
      <xsl:value-of select="$ColumnSeparator" />
      
      <xsl:value-of select="../../QualityGrade"/>
      <xsl:value-of select="$ColumnSeparator" />
      
      <xsl:value-of select="../../QualityGradeOriginal"/>
      <xsl:value-of select="$ColumnSeparator" />

      <!--
      <xsl:value-of select="../../Systeminterpretation"/>
      <xsl:value-of select="$ColumnSeparator" />

      <xsl:value-of select="../../SysteminterpretationOriginal"/>
      <xsl:value-of select="$ColumnSeparator" />
      -->


      <!-- == Results / Parameter == -->
      <!-- values-->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbHumidity']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbPressure']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbTemp']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbTemp_Fahr']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ATI']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='BEV']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='BHT']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='BTPSex']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='BTPSin']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='CEV']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='COHb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ColBarVol']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationCO']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationHE']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationInVitroCO']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationInVitroCO2']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationInVitroHE']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationInVitroO2']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationO2']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='CVI']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DeadSpaceAnatomic']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DeadSpaceSystem']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DiscardVol']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj_SI']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj_VA']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj_SI_VA']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO_SI']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO_VA']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO_SI_VA']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='E50_I50']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='EOTV']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='ERV']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FAco']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FAhe']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEco']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF10']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF25']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF2575']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF2575_FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF2575_6']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF40']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF50']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF50_FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF50_VCmax']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF60']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF75']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF7585']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEF80']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FET']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FET2575']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_25']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_5']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_5_FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_75']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_75_FEV6']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_75_FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV_75_VCmax']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_FEV6']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_FIV1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_FVC6']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_VCmax']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV1_VCext']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV3']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV3_FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV3_VCmax']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEV6']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIco']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIF25']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIF50']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIF50_FEF50']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIF75']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIhe']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIV_25']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIV_5']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIV1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCsb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCbase']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCsbCor']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCextrapol']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCmb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FT']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FVC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FVC6']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='Hb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='Hb_g_dl']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='IC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='InspTime']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='IRV']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='KroghsK']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='LCI']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MEF20']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MEF25']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MEF40']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MEF50']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MEF60']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MEF75']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MEF90']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MIF25']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MIF50']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MIF75']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MMEF']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='M0']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MR1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MR2']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MsgNo']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MTC1']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MTC2']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MTC3']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MTCR']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MVV']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MVV6']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MVVtime']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PAO2']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PAO2_mmHg']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PEF']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PEF_L_Min']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PEFT']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PIF']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='PIF_L_Min']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RF']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RVsb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RVsbCor']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RVmb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RV_TLCsb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RV_TLCsbCor']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RV_TLCmb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='STPD']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='SyringeVol']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='T0']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCmb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCsb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCsbCor']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCO']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VAsb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VACor']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VAmb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VC']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VCex']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VCext']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VCin']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VCmax']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='Vd']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VI']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VT']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VT_FRCmb']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VT_kg']/DataValue"/>
      <xsl:value-of select="$ColumnSeparator" />



      <!-- add carriag return => new line -->      
      <xsl:text>&#13;&#10;</xsl:text>



    </xsl:for-each>

    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>&#13;&#10;</xsl:text>

    <!--Add Summary report-->
    <xsl:text>nr. of patients: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfPatients" select="//Patients/Patient"/>
    <xsl:value-of select="count($NumberOfPatients)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of test sessions: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfIntervals" select="//Patients/Patient/Intervals/Interval"/>
    <xsl:value-of select="count($NumberOfIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of FVC sessions: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfFVCIntervals" select="//Patients/Patient/Intervals/Interval[Tests/Test[@TypeOfTest='FVC']]"/>
    <xsl:value-of select="count($NumberOfFVCIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of FVC trials: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfFVCTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FVC']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfFVCTrials)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of FVL sessions: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfFVLIntervals" select="//Patients/Patient/Intervals/Interval[Tests/Test[@TypeOfTest='FVL']]"/>
    <xsl:value-of select="count($NumberOfFVLIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of FVL trials: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfFVLTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FVL']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfFVLTrials)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of SVC sessions: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfSVCIntervals" select="//Patients/Patient/Intervals/Interval[Tests/Test[@TypeOfTest='SVC']]"/>
    <xsl:value-of select="count($NumberOfSVCIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of SVC trials: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfSVCTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='SVC']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfSVCTrials)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of DLCO sessions: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfDLCOIntervals" select="//Patients/Patient/Intervals/Interval[Tests/Test[@TypeOfTest='DLCO']]"/>
    <xsl:value-of select="count($NumberOfDLCOIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of DLCO trials: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfDLCOTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='DLCO']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfDLCOTrials)"/>
    <xsl:text>&#13;&#10;</xsl:text>

    <xsl:text>nr. of FRC sessions: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfFRCIntervals" select="//Patients/Patient/Intervals/Interval[Tests/Test[@TypeOfTest='FRC']]"/>
    <xsl:value-of select="count($NumberOfFRCIntervals)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of FRC trials: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfFRCTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FRC']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfFRCTrials)"/>
    <xsl:text>&#13;&#10;</xsl:text>

  </xsl:template>
</xsl:stylesheet>
