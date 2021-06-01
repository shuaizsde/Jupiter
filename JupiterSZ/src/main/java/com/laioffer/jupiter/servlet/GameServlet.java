package com.laioffer.jupiter.servlet;
//Now we can use JSON in this class
import com.laioffer.jupiter.external.TwitchClient;
import com.laioffer.jupiter.external.TwitchException;
//this is for post Method， Input/OutputUtils  阿帕奇公司即做maven 的公司

//我们把jackson 和entity都引入进来
import com.fasterxml.jackson.databind.ObjectMapper;

//those are all default imports
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameServlet",urlPatterns = {"/game"})

public class GameServlet extends HttpServlet {
    //GameServlet不需要 DoPost， 下列代码是之前课上的demo

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //这句话是：先把request给read了，然后再把它toString了， 最后把他to Json
//        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
//        String name = jsonRequest.getString("name");
//        String developer = jsonRequest.getString("developer");
//        String releaseTime = jsonRequest.getString("release_time");
//        String website = jsonRequest.getString("website");
//        float price = jsonRequest.getFloat("price");
//
//        // Print game information to IDE console
//        System.out.println("Name is: " + name);
//        System.out.println("Developer is: " + developer);
//        System.out.println("Release time is: " + releaseTime);
//        System.out.println("Website is: " + website);
//        System.out.println("Price is: " + price);
//
//        // Return status = ok as response body to the client
//        response.setContentType("application/json");
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("status", "ok");
//        response.getWriter().print(jsonResponse);
//
//    }

    //Every request is separated, there is no support for doing one post request in several post requests,
    // or doing a delete in a pair of get and post requests.（？这意味着同一时间只能有一个用户进行doGet doPost吗）

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String gameName = request.getParameter("game_name");
        TwitchClient client = new TwitchClient();
        // Let the client know the returned data is in JSON format. 这里已经设置好了返回的格式是json！
        response.setContentType("application/json;charset=UTF-8");
        try {
            // Return the dedicated game information if gameName is provided in the request URL, otherwise return the top x games.
            if (gameName != null) {
                response.getWriter().print(new ObjectMapper().writeValueAsString(client.searchGame(gameName)));
            } else {//response的显示就这么写就完事了
                response.getWriter().print(new ObjectMapper().writeValueAsString(client.topGames(0)));
            }
        } catch (TwitchException e) {
            throw new ServletException(e);
        }

        //下列代码是之前课上的demo， 未用到

        //response.setContentType("application/json");
        //这个object mapper就是jackson里的class
        //ObjectMapper mapper = new ObjectMapper();
        //这个game现在就是jackson处理之后的java class， 现在已经在这里自动被我们搞成了json格式了


    }
}
