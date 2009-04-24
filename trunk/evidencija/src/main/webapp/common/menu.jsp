<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
    <c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="Logout"/>
    <!--Tim-START-->
    <menu:displayMenu name="TimMenu"/>
    <!--Tim-END-->
    <!--Zanimanje-START-->
    <menu:displayMenu name="ZanimanjeMenu"/>
    <!--Zanimanje-END-->
    <!--Zaposleni-START-->
    <menu:displayMenu name="ZaposleniMenu"/>
    <!--Zaposleni-END-->
    <!--Pripada-START-->
    <menu:displayMenu name="PripadaMenu"/>
    <!--Pripada-END-->
    <!--Angazovan-START-->
    <menu:displayMenu name="AngazovanMenu"/>
    <!--Angazovan-END-->
</ul>
</menu:useMenuDisplayer>