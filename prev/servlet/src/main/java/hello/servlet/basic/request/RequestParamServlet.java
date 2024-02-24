package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;


// 파라미터 전송 기능
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 전체 파라미터 출력

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));
        System.out.println();

        // 단일 파라미터 조회
        String userName = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("userName = " + userName);
        System.out.println("age = " + age);
        System.out.println();

        // 이름이 같은 복수 파라미터 조회
        String[] userNames = request.getParameterValues("username");
        for (String name : userNames) {
            System.out.println("name = " + name);
        }

        response.getWriter().write("ok");
    }
}
