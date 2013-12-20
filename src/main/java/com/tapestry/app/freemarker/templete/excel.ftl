<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>${reportname}</x:Name><x:WorksheetOptions><x:Selected/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]-->
    <style type="text/css">
        .td
        {
            width: 100px;
        }
        .gdtjContainer .tb tr
        {
            text-align: center;
            vertical-align: middle;
        }
        .gdtjContainer .tb th
        {
            border-left: 0.5pt solid #000;
            border-right: 0.5pt solid #000;
            border-bottom: 0.5pt solid #000;
            text-align: center;
            font-weight: normal;
            font-size: 10pt;
            middle: ;;height:15px;}
        .gdtjContainer .header th
        {
            font-size: 12pt;
        }
        .gdtjContainer .tb tr th.noleftborder
        {
            border-left: none;
        }
        .gdtjContainer .tb tr th.rightborder
        {
            border-right: 0.5pt solid #000;
        }
    </style>
</head>
<body>
    <div class="gdtjContainer">
        <table class="tb" cellspacing="0" cellpadding="0" border="0.5" width="70%">
            <tr style="height: 40px">
                <th style="font-size: 14pt; font-family: 宋体;" colspan="${tablehead?size}">
                   <strong>${reportname}</strong>
                </th>
            </tr>
            <tr>
                <th style="text-align:left; font-size: 10pt; font-family: 宋体;" colspan="${tablehead?size}">
                ${info}
                </th>
            </tr>
            <tr>
            	<#assign map = tablehead>
            	<#list map?keys as key>
                <th style="text-align: center; font-size: 10pt; border-left: none;">
                    <strong>${map[key]}</strong>
                </th>
                </#list>
            </tr>
            <#list userlist as info>
            <tr>
				<#list info as temp>
				<th style="text-align: left; font-size: 10pt; border-left: none;">
                    ${temp}
                </th>
				</#list>
            </tr>
            </#list>
            <tr>
                <th style="text-align:left; font-size: 10pt; font-family: 宋体;" colspan="${tablehead?size}">
                ${tablefoot}
                </th>
            </tr>
        </table>
    </div>
</body>
</html>