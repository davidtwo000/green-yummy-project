<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>userList</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .header {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: right;
        }
        .header span {
            margin-right: 15px;
        }
        .content-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .content h1 {
            margin-bottom: 20px;
            display: inline-block;
        }
        .search-box {
            display: flex;
            align-items: center;
            margin-bottom: -20px;
        }
        .search-box input[type="text"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-right: 5px;
        }
        .search-box button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .search-box button:hover {
            background-color: #575757;
        }
        .table {
            width: 100%;
            border-collapse: collapse;
            height:631px;
            display: block;
        }
        .table th, .table td{
            border: 1px solid #ddd;
        }
        .table th, .table td {
            padding: 10px;
            text-align: left;
            height:38px;
        }
        .table th {
            background-color: #333;
            color: white;
            height:18px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #333;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .table tr, tbody{
        	width:100%;
        }
        .btn:hover {
            background-color: #575757;
        }
        .table th:nth-child(1), .table td:nth-child(1), 
		.table th:nth-child(7), .table td:nth-child(7) { 
		    width: 10%;
		}
		.table th:nth-child(5), .table td:nth-child(5) {
		    width: 22%;
		}
		.table th:nth-child(2), .table td:nth-child(2), 
		.table th:nth-child(3), .table td:nth-child(3),
		.table th:nth-child(4), .table td:nth-child(4),
		.table th:nth-child(6), .table td:nth-child(6) {
			width: 17%;
		}
		button[disabled] {
		    cursor: not-allowed;
		    opacity: 0.5; /* 선택 사항: 비활성화된 느낌을 주기 위해 투명도 변경 */
		}
		div#button-area{
			margin-top:30px;
			text-align:center;
		}
		select{
			width:150px;
			height:30px;
			font-size:18px;
		}
		#radioBox{
			position:absolute;
			left:150px;
		}
    </style>
	<script>
	    function alarm(){
	    	let message = "<%= request.getParameter("message") %>";
	    	if(message == "create")
	    		alert("정보가 추가되었습니다.");
	    	else if(message == "delete")
	    		alert("정보가 삭제되었습니다.");
	    }	
    </script>
</head>
<body onload="alarm()">
    <div class="header">
        <span>Welcome, Admin</span>
    </div>
    <div class="content">
        <div class="content-header">
            <h1>사용자</h1>
            <div class="search-box">
            <form action="/admin/sortUser" method="post" id="radioBox">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            		<label>
				        <input type="radio" name="role" value="USER"
				        ${condition == 'USER' ? 'checked' : ''}>사용자
				    </label>
				    <label>
				        <input type="radio" name="role" value="ADMIN"
				        ${condition == 'ADMIN' ? 'checked' : ''}>관리자
				    </label>
            	</form>
                <form action="/admin/searchUser" method="post">
                <select name="searchType">
                	<option value="total">전체</option>
			        <option value="id">아이디</option>
			        <option value="name">이름</option>
			        <option value="phone">전화번호</option>
			    </select>
                <input type="text" placeholder="검색..." name="search">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button type="submit">검색</button>
                </form>
            </div>
        </div>
        <table class="table">
	        <tbody>
	            <tr>
	                <th>
	                <form action="/admin/userList" method="get" id="radioBox1">
					<label>
				        <input type="radio" name="order" value="asc"
				        ${order == 'asc' ? 'checked' : ''}>asc
				    </label>
				    <label>
				        <input type="radio" name="order" value="desc"
				        ${order == 'desc' ? 'checked' : ''}>desc
				    </label>
				    </form>
					</th>
	                <th>ID</th>
	                <th>NAME</th>
	                <th>TEL</th>
	                <th>EMAIL</th>
	                <th>ROLE</th>
	                <th>ACTIONS</th>
	            </tr>
	            <c:forEach var='user' items='${userDTO }' varStatus="status">
	            <tr>
	                <td>${status.index + 1 + (page-1)*10 }</td>
	                <td>${user.id }</td>
	                <td>${user.name }</td>
	                <td>${user.phone }</td>
	                <td>${user.email }</td>
	                <c:choose>
	                	<c:when test='${user.admin}'>
	                		<td>관리자</td>
	                	</c:when>
	                	<c:otherwise>
	                		<td>사용자</td>
	                	</c:otherwise>
	                </c:choose>
	                <td><a href="/admin/userDetail?id=${user.userUkId}" class="btn">View</a></td>
	            </tr>
	            </c:forEach>
            </tbody>
        </table>
        <div id="button-area">
        <c:choose>
        	<c:when test='${status == -1}'>
		        <button disabled class="btn">&lt;&lt;</button>
		        <button style="margin-left:30px;" onclick = 'location="/admin/userList?page=${page+1}"' class="btn">&gt;&gt;</button>
	        </c:when>
	        <c:when test='${status == 0}'>
		        <button onclick = 'location="/admin/userList?page=${page-1}"' class="btn">&lt;&lt;</button>
		        <button onclick = 'location="/admin/userList?page=${page+1}"' class="btn" style="margin-left:30px;">&gt;&gt;</button>
	        </c:when>
	        <c:when test='${status == 1}'>
		        <button onclick = 'location="/admin/userList?page=${page-1}"' class="btn">&lt;&lt;</button>
		        <button disabled class="btn" style="margin-left:30px;">&gt;&gt;</button>
	        </c:when>
	        <c:otherwise></c:otherwise>
        </c:choose>
        </div>
    </div>
    <script>
        const radios = document.querySelectorAll('input[type="radio"][name="role"]');
        
        radios.forEach(radio => {
            radio.addEventListener('change', function() {
                document.getElementById('radioBox').submit();
            });
        });
        
        const radios1 = document.querySelectorAll('input[type="radio"][name="order"]');
        
        radios1.forEach(radio => {
        	radio.addEventListener('change', function() {
        		document.getElementById('radioBox1').submit();
        	});
        });
    </script>
</body>
</html>
