<%
int x = 3;
int y = 4;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
 input {
		width : 50%;
		height : 50%;
	}
.output { 
		height : 50px;
		background :#e9e9e9;
		font-size : 24px;
		font-weight : bold;
		text-align : right;
		padding : 0px 5px;
	} 
</style>
<body>
	<form action="calc3" method="post">
		<table>
			<tr>
				<td class="output" colspan="4">0</td>
			</tr>
			<tr>
				<td input="submit" name="op" value="CE"></td>
				<td input="submit" name="op" value="C"></td>
				<td input="submit" name="op" value="BS"></td>
				<td input="submit" name="op" value="÷"></td>
			</tr>
			<tr>
				<td input="submit" name="value" value="7"></td>
				<td input="submit" name="value" value="8"></td>
				<td input="submit" name="value" value="9"></td>
				<td input="submit" name="op" value="X"></td>
			</tr>
			<tr>
				<td input="submit" name="value" value="4"></td>
				<td input="submit" name="value" value="5"></td>
				<td input="submit" name="value" value="6"></td>
				<td input="submit" name="op" value="-"></td>
			</tr>
			<tr>
				<td input="submit" name="value" value="1"></td>
				<td input="submit" name="value" value="2"></td>
				<td input="submit" name="value" value="3"></td>
				<td input="submit" name="op" value="+"></td>
			</tr>
			<tr>
				<td></td>
				<td input="submit" name="value" value="0"></td>
				<td input="submit" name="dot" value="."></td>
				<td input="submit" name="op" value="="></td>
			</tr>
		</table>
	</form>
</body>
</html>