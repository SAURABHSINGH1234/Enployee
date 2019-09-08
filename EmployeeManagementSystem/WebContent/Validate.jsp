<jsp:useBean id="user" class="model.Emp"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<jsp:forward page="<%=user.Validate()%>"></jsp:forward>
