
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.File;


public class myClient 
{
    public static String fetchIndex()
    {
        String url = "http://localhost:9000/";
        try
        {
          HttpResponse<String> res = Unirest.get(url).asString();
        if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return e.toString();
        }
        return "error";
    }
     public static String userlogin(String username,String password) 
    {
        try
        {
          String url="http://localhost:9000/userlogin"  ;
          HttpResponse<String> res = Unirest.get(url)
                  .queryString("username",username)
                  .queryString("password",password)
                  .asString();
        if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return e.toString();
        }
        return "error";
    }
     public static String otpsend(String email,String mobile)
     {
         try 
         {
             String url = "http://localhost:9000/otpsend";
              HttpResponse<String> res = Unirest.get(url)
                      .queryString("email", email)
                      .queryString("mobile",mobile)
                      .asString();
              if(res.getStatus()==200)
              {
                  return res.getBody();
              }
         } 
         catch (Exception e)
         {
             return e.toString();
         }
         return "error";
     }
     public static String usersignup(String email, String pass, String mobile, String address, String uotp, File ph)
     {
         try 
         {
             String url ="http://localhost:9000/usersignup";
             HttpResponse<String> res = Unirest.post(url)
                     .queryString("email", email)
                      .queryString("pass", pass)
                      .queryString("mobile", mobile)
                      .queryString("address", address)
                     .queryString("uotp",uotp)
                     .field("f1", ph)
                     .asString();
             if(res.getStatus()==200)
              {
                 
                  return res.getBody();
              }
             
         } 
         
         catch (Exception e)
         {
             e.printStackTrace();
            return e.toString();
         }
         return null;
     }
     public static String fetchcat()
     {
         try 
         {
             String url ="http://localhost:9000/fetchcat";
             HttpResponse<String> res= Unirest.get(url).asString();
             if(res.getStatus()==200)
             {
                 return res.getBody();
             }
             else
             {
                 return "server error";
             }
         } 
         catch (Exception e) 
         {
             return e.toString();
         }
     }
     public static String adminlogin(String admin,String password)
     {
         try 
         {
             String url ="http://localhost:9000/adminlogin";
             HttpResponse<String> res = Unirest.get(url)
                     .queryString("admin",admin)
                  .queryString("password",password)
                  .asString();
        if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        else
        {
            return "server error";
        }
         }
         catch (Exception e)
         {
             return e.toString();
         }
     }
     public static String addcategory(String catname, File ph)
     {
         try 
         {
             String url ="http://localhost:9000/addcategory";
             HttpResponse<String> res = Unirest.post(url)
                     .queryString("catname",catname)
                     .field("f1",ph)
                     .asString();
             if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        else
        {
            return "server error";
        }
         } 
         catch (Exception e) 
         {
              return e.toString();
         }
     }
     
     public static String fetchcategories()
     {
         String url ="http://localhost:9000/fetchcategories";
         
         try 
         {
          HttpResponse<String> res = Unirest.get(url).asString();
         if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        else
        {
            return "server error";
        }
         } 
         catch (Exception e)
         {
             return e.toString();
         }
     }
     
     public static String addmovie(String category, String mname,String director,String cast,String id,String tid,File ph1)
     {
         String url ="http://localhost:9000/addmovies";
         try 
         {
             HttpResponse<String> res = Unirest.post(url)
                     .queryString("category",category)
                     .queryString("mname",mname)
                     .queryString("director",director)
                     .queryString("cast",cast)
                     .queryString("id",id)
                     .queryString("tid",tid)
                     .field("f2",ph1)
                     .asString();
             
             if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        else
        {
            return "server error";
        }
                             
         } 
         catch (Exception e)
         {
              return e.toString();
         }
     }
     
     public static String fetchmovies(String category)
     {
         String url ="http://localhost:9000/fetchmovies";
         try 
         {
             HttpResponse<String> res = Unirest.get(url)
                     .queryString("category",category)
                     .asString();
             if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        else
        {
            return "server error";
        }
         } 
         catch (Exception e) 
         {
              return e.toString();
         }
     }
     
     public static String loadmovie(int id)
     {
         String url ="http://localhost:9000/loadmovie";
         try 
         {
             HttpResponse<String> res = Unirest.get(url)
                     .queryString("id",id)
                     .asString();
             if(res.getStatus()==200)
        {
            String ans = res.getBody();
            return ans;
        }
        else
        {
            return "server error";
        }
             
         } 
         catch (Exception e) 
         {
             return e.toString();
         }
     }
     
     public static String search(String name)
     {
         System.out.println("name----"+name);
         String url ="http://localhost:9000/search";
         try
         {
             HttpResponse<String> res = Unirest.get(url)
                     .queryString("name",name)
                     .asString();
             if(res.getStatus()==200)
        {
            String ans = res.getBody();
            System.out.println("myclient------"+ans);
            return ans;
        }
        else
        {
            return "server error";
        }
           
         } 
         catch (Exception e)
         {
             return e.toString();
         }
     }
}
