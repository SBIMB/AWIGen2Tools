<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" omit-xml-declaration="yes" />

  <xsl:param name="ColumnSeparator"
             select="';'" />


  <xsl:template match="/">
    <!-- Title (first row) -->
    <xsl:text>Patient ID</xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>Date</xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>Trial #</xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>Test Type</xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>Accepted</xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>FRCmb             </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>LCI               </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>M0                </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>MR1               </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>MR2               </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>CEV               </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>DeadSpaceAnatomic </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>DeadSpaceSystem   </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>FT                </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>RVmb              </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>TLCmb             </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>VAmb              </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>Vd                </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>VT                </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>FRCbase           </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>FRCextrapol       </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>RV_TLCmb          </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>VT_FRCmb          </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>AmbPressure       </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>AmbTemp           </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>AmbTemp_Fahr      </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>AmbHumidity       </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>BTPSin            </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>BTPSex            </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>MsgNo             </xsl:text><xsl:value-of select="$ColumnSeparator"/>
    <xsl:text>&#13;&#10;</xsl:text>
    
    
    <!-- create a row for each test session-->
    <xsl:for-each select="//Intervals/Interval/Tests/Test[@TypeOfTest='FRC']/Trials/Trial">
      
      <!-- Patient ID -->
      <xsl:value-of select="../../../../../../@ID"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- Date -->
      <xsl:value-of select="Date"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- Trial # -->
      <xsl:value-of select="Number"/>
      <xsl:value-of select="$ColumnSeparator"/>
      
      <!-- Test Type-->
      <xsl:value-of select="../..//@TypeOfTest"/>
      <xsl:value-of select="$ColumnSeparator"/>

      <!-- Accepted -->
      <xsl:value-of select="Accepted"/>
      <xsl:value-of select="$ColumnSeparator"/>


      <!-- values-->
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCmb'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='LCI'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='M0'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MR1'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MR2'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='CEV'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DeadSpaceAnatomic'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='DeadSpaceSystem'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FT'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RVmb'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='TLCmb'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VAmb'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='Vd'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VT'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCbase'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='FRCextrapol'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='RV_TLCmb'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='VT_FRCmb'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbPressure'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbTemp'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbTemp_Fahr'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='AmbHumidity'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='BTPSin'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='BTPSex'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>
      <xsl:value-of select="ResultParameters/ResultParameter[@ID='MsgNo'                             ]/DataValue"/><xsl:value-of select="$ColumnSeparator"/>

      <!-- new line for next trial -->
      <xsl:text>&#13;&#10;</xsl:text>
     
    </xsl:for-each>

    <!--Add Summary report-->
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>&#13;&#10;</xsl:text>
    <xsl:text>nr. of patients: </xsl:text>
    <xsl:variable name="NumberOfPatients" select="//Patients/Patient"/>
    <xsl:value-of select="count($NumberOfPatients)"/>
    <xsl:text>;&#13;&#10;</xsl:text>
    <xsl:text>nr. of test sessions (as well none FRC): </xsl:text>
    <xsl:variable name="NumberOfIntervals" select="//Patients/Patient/Intervals/Interval"/>
    <xsl:value-of select="count($NumberOfIntervals)"/>
    <xsl:text>;&#13;&#10;</xsl:text>
    <xsl:text>nr. of FRC tests (pre and post): </xsl:text>
    <xsl:variable name="NumberOfTests" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FRC']"/>
    <xsl:value-of select="count($NumberOfTests)"/>
    <xsl:text>;&#13;&#10;</xsl:text>
    <xsl:text>nr. of frc trials: </xsl:text>
    <xsl:variable name="NumberOfTrials" select="//Patients/Patient/Intervals/Interval/Tests/Test[@TypeOfTest='FRC']/Trials/Trial"/>
    <xsl:value-of select="count($NumberOfTrials)"/>


  </xsl:template>
</xsl:stylesheet>
