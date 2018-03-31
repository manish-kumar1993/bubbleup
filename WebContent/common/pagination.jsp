
<% String url= request.getParameter("url"); 
 String currentPageStr =request.getParameter("page"); 
 String pageQntyStr =request.getParameter("pageQnty") ;
 String totalCountStr= request.getParameter("totalCount");
   int totalCount =0;
   try{
	   totalCount = Integer.parseInt(totalCountStr);
   }catch (Exception e){}
   
   int currentPage=1;
   try{
	   currentPage = Integer.parseInt(currentPageStr);
   }catch (Exception e){}
   
   int pageQnty =50;
   try{
	   pageQnty = Integer.parseInt(pageQntyStr);
   }catch (Exception e){}
   
   int totalPages= (int)java.lang.Math.ceil((totalCount+pageQnty-1)/pageQnty) ;
   int currentPageLess= currentPage-1;
   int currentPageMore= currentPage+1;
   
   
%>
<div class="text-center">
	<ul class="pagination">
		<% if(currentPageLess > 0 && totalPages>1 ){ %>
		<li>
			<a href="<%=url+"&page="+currentPageLess%>">
				<i class="icon-left-open-mini"></i>
			</a>
		</li>
		<% } %>
		<% if(currentPageLess > 0 && totalPages>1 ){ %>
		<li>
			<a href="<%=url+"&page="+currentPageLess%>"><%=currentPageLess%></a>
		</li>
		<% } %>
		<% if(totalPages > 1 ){ %>
		<li class="active">
			<a href="<%=url+"&page="+currentPage%>"><%=currentPage%></a>
		</li>
		<%} %>
		<% if(currentPageMore <= totalPages && totalPages > 1 ){ %>
		<li>
			<a href="<%=url+"&page="+currentPageMore%>"><%=currentPageMore%></a>
		</li>
		<%} %>
		<% if(currentPageMore <= totalPages && totalPages > 1 ){ %>
		<li>
			<a href="<%=url+"&page="+currentPageMore%>">
				<i class="icon-right-open-mini"></i>
			</a>
		</li>
		<% } %>
	</ul>
</div>