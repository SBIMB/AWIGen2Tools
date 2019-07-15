<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />
  <xsl:param name="ColumnSeparator" select="';'" /> <!-- this needs to be changed, depending on your regional setting e.g. to ','-->

  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text>Patient ID;</xsl:text>
    <xsl:text>Date;</xsl:text>
    <xsl:text>Trial #;</xsl:text>
    <xsl:text>Number of trials;</xsl:text>
    <xsl:text>Test Type;</xsl:text>
    <xsl:text>Accepted;</xsl:text>
    <xsl:text>Accepted Original;</xsl:text>
    <xsl:text>AmbHumidity;</xsl:text>
    <xsl:text>AmbPressure;</xsl:text>
    <xsl:text>AmbTemp;</xsl:text>
    <xsl:text>AmbTemp_Fahr;</xsl:text>
    <xsl:text>BHT;</xsl:text>
    <xsl:text>BTPSex;</xsl:text>
    <xsl:text>BTPSin;</xsl:text>
    <xsl:text>COHb;</xsl:text>
    <xsl:text>ColBarVol;</xsl:text>
    <xsl:text>ConcentrationCO;</xsl:text>
    <xsl:text>ConcentrationHE;</xsl:text>
    <xsl:text>ConcentrationO2;</xsl:text>
    <xsl:text>DeadSpaceAnatomic;</xsl:text>
    <xsl:text>DeadSpaceSystem;</xsl:text>
    <xsl:text>DiscardVol;</xsl:text>
    <xsl:text>DLadj;</xsl:text>
    <xsl:text>DLadj_SI;</xsl:text>
    <xsl:text>DLadj_SI_VA;</xsl:text>
    <xsl:text>DLadj_VA;</xsl:text>
    <xsl:text>DLCO;</xsl:text>
    <xsl:text>DLCO_SI;</xsl:text>
    <xsl:text>DLCO_SI_VA;</xsl:text>
    <xsl:text>DLCO_VA;</xsl:text>
    <xsl:text>FAco;</xsl:text>
    <xsl:text>FAhe;</xsl:text>
    <xsl:text>FEco;</xsl:text>
    <xsl:text>FIco;</xsl:text>
    <xsl:text>FIhe;</xsl:text>
    <xsl:text>FRCsb cor;</xsl:text><!--Functional residual capacity measured single breath, Punjabi corrected-->
    <xsl:text>FRCsb;</xsl:text><!--Functional residual capacity measured single breath-->    
    <xsl:text>Hb;</xsl:text>
    <xsl:text>Hb_g_dl;</xsl:text>
    <xsl:text>InspTime;</xsl:text>
    <xsl:text>KroghsK;</xsl:text>
    <xsl:text>MsgNo;</xsl:text>
    <xsl:text>RV_TLCsb;</xsl:text>
    <xsl:text>RVsb cor;</xsl:text> <!--Residual volume calculated from TLC single breath test, Punjabi corrected-->
    <xsl:text>RVsb;</xsl:text>
    <xsl:text>STPD;</xsl:text>
    <xsl:text>TLCO;</xsl:text>
    <xsl:text>TLCsb cor;</xsl:text>
    <xsl:text>TLCsb;</xsl:text>
    <xsl:text>VAsb cor;</xsl:text>  <!--Alveolar volume, BTPS corrected and Punjabi corrected-->
    <xsl:text>VAsb;</xsl:text>
    <xsl:text>VCmax;</xsl:text>
    <xsl:text>Vd;</xsl:text>
    <xsl:text>VI;</xsl:text>

    <xsl:text>&#13;&#10;</xsl:text>


    <!-- create a row for each test session-->
    <xsl:for-each select="//Intervals/Interval/Tests/Test[@TypeOfTest='DLCO']/Trials/Trial">

      <!-- Patient ID -->
      <xsl:value-of select="../../../../../../@ID"/>
      <xsl:text>;</xsl:text>

      <!-- Date -->
      <xsl:value-of select="Date"/>
      <xsl:text>;</xsl:text>

      <!-- Trial # -->
      <xsl:value-of select="Number"/>
      <xsl:text>;</xsl:text>

      <!-- Number of trials -->
      <xsl:value-of select="count(../../Trials/Trial)"/>
      <xsl:text>;</xsl:text>    
      
      <!-- Test Type-->
      <xsl:value-of select="../..//@TypeOfTest"/>
      <xsl:text>;</xsl:text>

      <!-- Accepted -->
      <xsl:value-of select="Accepted"/>
      <xsl:text>;</xsl:text>

      <!-- Accepted -->
      <xsl:value-of select="AcceptedOriginal"/>
      <xsl:text>;</xsl:text>
      
      <!-- values-->

      <!--
      Regex replacement find string
      [\r\n]*\<Unit\>*[^;]*Unit\>*[\r\n]*[^;]*[\r\n]*[^;]*[\r\n]*[^;]*Parameter\>-->

        <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbHumidity'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbPressure'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbTemp'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbTemp_Fahr'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='BHT'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='BTPSex'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='BTPSin'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='COHb'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='ColBarVol'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationCO'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationHE'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='ConcentrationO2'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DeadSpaceAnatomic'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DeadSpaceSystem'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DiscardVol'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj'                             ]/DataValue"/><xsl:text>;</xsl:text>       
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj_SI'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj_SI_VA'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLadj_VA'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO_SI'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO_SI_VA'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='DLCO_VA'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FAco'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FAhe'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FEco'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIco'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FIhe'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCsbCor'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCsb'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='Hb'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='Hb_g_dl'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='InspTime'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='KroghsK'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='MsgNo'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='RV_TLCsb'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='RVsbCor'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='RVsb'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='STPD'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCO'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCsbCor'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCsb'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='VACor'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='VAsb'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='VCmax'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='Vd'                             ]/DataValue"/><xsl:text>;</xsl:text>
        <xsl:value-of select="ResultParameters/ResultParameter[@ID='VI'                             ]/DataValue"/><xsl:text>;</xsl:text>

      <!-- new line for next trial -->
      <xsl:text>&#13;&#10;</xsl:text>

    </xsl:for-each>

    <!--Add Summary report-->
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>&#13;&#10;</xsl:text>
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

    <xsl:text>nr. of DLCO tests (pre and post): </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfDlcoTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='DLCO']"/>
    <xsl:value-of select="count($NumberOfDlcoTests)"/>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of DLCO trials: </xsl:text>
    <xsl:value-of select="$ColumnSeparator" />
    <xsl:variable name="NumberOfDlcoTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='DLCO']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfDlcoTrials)"/>



  </xsl:template>
</xsl:stylesheet>
