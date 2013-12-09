<?xml version="1.0" encoding="GBK"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Author>${author}</Author>
  <LastAuthor>${author}</LastAuthor>
  <Created>${createdate}</Created>
  <Version>12.00</Version>
 </DocumentProperties>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>9150</WindowHeight>
  <WindowWidth>14940</WindowWidth>
  <WindowTopX>360</WindowTopX>
  <WindowTopY>270</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
	<Styles>
		<Style ss:ID="Default" ss:Name="Normal">
			<Alignment ss:Vertical="Bottom"/>
			<Borders/>
			<Font ss:FontName="Arial" x:Family="Swiss"/>
			<Interior/>
			<NumberFormat/>
			<Protection/>
		</Style>
		<Style ss:ID="s25">
			<Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
			<Font ss:FontName="宋体" x:CharSet="134" ss:Size="14" ss:Bold="1"/>
		</Style>
		<Style ss:ID="s27">
			<Alignment ss:Horizontal="Left" ss:Vertical="Center"/>
			<Font ss:FontName="宋体" x:CharSet="134"/>
		</Style>
		<Style ss:ID="s28">
			<Alignment ss:Horizontal="Center" ss:Vertical="Center"/>
			<Borders>
				<Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
				<Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
				<Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
				<Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
			</Borders>
			<Font ss:FontName="宋体" x:CharSet="134" ss:Bold="1"/>
		</Style>
		<Style ss:ID="s29">
			<Alignment ss:Horizontal="Left" ss:Vertical="Center"/>
			<Borders>
				<Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
				<Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
				<Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
				<Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"
					ss:Color="#000000"/>
			</Borders>
			<Font ss:FontName="宋体" x:CharSet="134"/>
		</Style>
	</Styles>
	<Worksheet ss:Name="${reportname}">
		<Table ss:ExpandedColumnCount="7" ss:ExpandedRowCount="7514" x:FullColumns="1"
			x:FullRows="1">
			<Column ss:Width="78.75" ss:Span="6"/>
			<Row>
				<Cell ss:MergeAcross="6" ss:MergeDown="1" ss:StyleID="s25">
					<Data
						ss:Type="String">${reportname}</Data>
				</Cell>
			</Row>
			<Row ss:Index="3">
				<Cell ss:MergeAcross="6" ss:StyleID="s27">
					<Data ss:Type="String">${info}</Data>
				</Cell>
			</Row>
			<Row>
				<#assign map = tablehead>
				<#list map?keys as key>
				<Cell ss:StyleID="s28">
					<Data ss:Type="String">${map[key]}</Data>
				</Cell>
				</#list>
			</Row>
			<#list userlist as user>
			<Row>
				<#assign map = user>
				<#list map?keys as key>
				<Cell ss:StyleID="s29">
					<Data ss:Type="String">${map[key]}</Data>
				</Cell>
				</#list>
			</Row>
			</#list>
			<Row>
				<Cell ss:MergeAcross="1">
					<Data ss:Type="String">${tablefoot.staff}</Data>
				</Cell>
				<Cell ss:MergeAcross="1">
					<Data ss:Type="String">${tablefoot.depart}</Data>
				</Cell>
				<Cell ss:MergeAcross="2">
					<Data ss:Type="String">${tablefoot.date}</Data>
				</Cell>
			</Row>
		</Table>
		<WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
			<Print>
				<FitWidth>0</FitWidth>
				<FitHeight>0</FitHeight>
				<ValidPrinterInfo/>
				<PaperSizeIndex>9</PaperSizeIndex>
				<HorizontalResolution>300</HorizontalResolution>
				<VerticalResolution>300</VerticalResolution>
			</Print>
			<Selected/>
			<Panes>
				<Pane>
					<Number>3</Number>
					<ActiveRow>17</ActiveRow>
					<ActiveCol>8</ActiveCol>
				</Pane>
			</Panes>
			<ProtectObjects>False</ProtectObjects>
			<ProtectScenarios>False</ProtectScenarios>
		</WorksheetOptions>
	</Worksheet>
</Workbook>