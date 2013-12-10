package com.tapestry.app.security;

import java.io.IOException;

import mx4j.tools.config.DefaultConfigurationBuilder.Register;

import org.apache.tapestry5.Link;
import org.apache.tapestry5.runtime.Component;
import org.apache.tapestry5.services.ComponentEventRequestParameters;
import org.apache.tapestry5.services.ComponentRequestFilter;
import org.apache.tapestry5.services.ComponentRequestHandler;
import org.apache.tapestry5.services.ComponentSource;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.PageRenderRequestParameters;
import org.apache.tapestry5.services.Response;

import com.tapestry.app.annotations.AnonymousAccess;
import com.tapestry.app.pages.crud.UserList;
import com.tapestry.app.pages.session.Signin;
import com.tapestry.app.services.Authenticator;


public class AuthenticationFilter implements ComponentRequestFilter
{

    private final PageRenderLinkSource renderLinkSource;
    private final ComponentSource componentSource;
    private final Response response;
    private final Authenticator authenticator;
    private String defaultPage = UserList.class.getSimpleName();
    private String signinPage = Signin.class.getSimpleName();
    private String signupPage = Register.class.getSimpleName();

    public AuthenticationFilter(PageRenderLinkSource renderLinkSource,
            ComponentSource componentSource, Response response, Authenticator authenticator)
    {
        this.renderLinkSource = renderLinkSource;
        this.componentSource = componentSource;
        this.response = response;
        this.authenticator = authenticator;
    }

    public void handleComponentEvent(ComponentEventRequestParameters parameters,
            ComponentRequestHandler handler) throws IOException
    {

        if (dispatchedToLoginPage(parameters.getActivePageName())) { return; }

        handler.handleComponentEvent(parameters);

    }

    public void handlePageRender(PageRenderRequestParameters parameters,
            ComponentRequestHandler handler) throws IOException
    {

        if (dispatchedToLoginPage(parameters.getLogicalPageName())) { return; }

        handler.handlePageRender(parameters);
    }

    private boolean dispatchedToLoginPage(String pageName) throws IOException
    {

        if (authenticator.isLoggedIn())
        {
            if (signinPage.equalsIgnoreCase(pageName) || signupPage.equalsIgnoreCase(pageName))
            {
                Link link = renderLinkSource.createPageRenderLink(defaultPage);
                response.sendRedirect(link);
                return true;
            }
            return false;
        }

        Component page = componentSource.getPage(pageName);

        if (page.getClass().isAnnotationPresent(AnonymousAccess.class)) { return false; }
        //返回登陆页面
        Link link = renderLinkSource.createPageRenderLink("Signin");

        response.sendRedirect(link);

        return true;
    }
}