<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
    <c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="Logout"/>
    
    <!--Casovi-START-->
    <menu:displayMenu name="CasoviMenu"/>
    <!--Casovi-END-->
    <!--Osoblje-START-->
    <menu:displayMenu name="OsobljeMenu"/>
    <!--Osoblje-END-->
    <!--Placanja-START-->
    <menu:displayMenu name="PlacanjaMenu"/>
    <!--Placanja-END-->
    <!--Polaznik-START-->
    <menu:displayMenu name="PolaznikMenu"/>
    <!--Polaznik-END-->
    <!--Vozilo-START-->
    <menu:displayMenu name="VoziloMenu"/>
    <!--Vozilo-END-->
</ul>
</menu:useMenuDisplayer>