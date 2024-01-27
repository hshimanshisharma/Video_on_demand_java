import com.vmm.JHTTPServer;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;
public class myServer extends JHTTPServer{
    
    public myServer(int port) throws IOException
    {
        super(port);
    }
    
   

    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) 
    {
        Response res = null;
         String otp =  (int) (1000+(9999-1000)*Math.random())+"";
        if(uri.equals("/"))
        {
            String ans=Math.random()+"";
            res = new Response (HTTP_OK, "text/plain", ans);
            
            
        }
        else if(uri.equals("/one"))
        {
            String ans=Math.random()+"";
            res = new Response (HTTP_OK, "text/plain", ans);
            
            
        }
        else if(uri.equals("/userlogin"))
        {
            String username= parms.getProperty("username");
            String password = parms.getProperty("password");
            try {
                
            ResultSet rs= DBLoader.executeQuery("select * from users where useremail='"+username+"' and password='"+password+"'");
            if(rs.next())
            {
                res= new Response(HTTP_OK,"text/plain","success");
            }
            else
            {
                res= new Response(HTTP_OK,"text/plain","fail");
            }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }

        }
        
        else if(uri.equals("/otpsend"))
        {
            String email = parms.getProperty("email");
            
            String mobile = parms.getProperty("mobile");
            
            
           
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select * from users where useremail='"+email+"'");
            if(rs.next())
            {
                res= new Response(HTTP_OK,"text/plain","exists");
            }
            else
            {
                ResultSet rs1 = DBLoader.executeQuery("select * from users where mobile='"+mobile+"'");
                if(rs1.next()|| mobile.length()!=10)
                {
                    res= new Response(HTTP_OK,"text/plain","mobile");
                }
                else
                {
                    
                    
                    sendemail obj = new sendemail(email,"hello","Your Otp is: "+otp);
                    res= new Response(HTTP_OK,"text/plain","sent");
                
                
                
                }
            }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
        }
        
        else if(uri.equals("/usersignup"))
        {
            
            String email = parms.getProperty("email");
            String password = parms.getProperty("pass");
            String mobile = parms.getProperty("mobile");
            String address = parms.getProperty("address");
            String uotp = parms.getProperty("uotp");
             String name = saveFileOnServerWithRandomName(files,parms,"f1","src/uploads");
            if (uotp.equals(otp))
            {
                try
                {
                 ResultSet rs1 = DBLoader.executeQuery("select * from users where useremail='"+email+"'");
            if(rs1.next())
            {
                res= new Response(HTTP_OK,"text/plain","exists");
            }
            else
            { 
                rs1.moveToInsertRow();
                rs1.updateString("useremail", email);
                rs1.updateString("password",password);
                rs1.updateString("mobile",mobile);
                rs1.updateString("address",address);
                rs1.updateString("photo","src/uploads/"+name);
                rs1.insertRow();
                res= new Response(HTTP_OK,"text/plain","success");
            }
                        
                }
                catch (Exception e) 
            {
                e.printStackTrace();
            }
                
                
            }
            else
            {
                 res= new Response(HTTP_OK,"text/plain","fail");
            }
        }
        
        else if(uri.equals("/fetchcat"))
        {
            String ans="";
            try
            {
            ResultSet rs = DBLoader.executeQuery("select * from category");
            while(rs.next())
            {
                String name =rs.getString("name");
                String photo =rs.getString("photo"); 
                String row = name+"$"+photo;
                ans=ans+row+";;";
                res= new Response(HTTP_OK,"text/plain",ans);
            }
            }
            catch(Exception e)
                    {
                        e.printStackTrace();
                    }
        }
        
        else if(uri.equals("/adminlogin"))
        {
            String name=parms.getProperty("admin");
            String password = parms.getProperty("password");
            System.out.println("name:"+name+"password:"+password);
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select * from admin where username = '"+name+"' and password = '"+password+"' ");
                if(rs.next())
                {
                     res= new Response(HTTP_OK,"text/plain","success");
                }
                else
                {
                res = new Response(HTTP_OK, "text/plain", "Fail");
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
        }
        
        else if(uri.equals("/addcategory"))
        {
            String catname=parms.getProperty("catname");
            String name = saveFileOnServerWithRandomName(files,parms,"f1","src/uploads/");
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select * from category where name = '"+catname+"' ");
                if(rs.next())
                {
                    res = new Response(HTTP_OK, "text/plain", "exist");
                }
                else
                {
                   rs.moveToInsertRow();
                   rs.updateString("name", catname);
                   rs.updateString("photo", "src/uploads/"+name);
                   rs.insertRow();
                   
                   res = new Response(HTTP_OK, "text/plain", "success");
                }
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
        }
        
        else if (uri.equals("/fetchcategories"))
        {
            String ans="";
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select name from category");
                
                while(rs.next())
                {
                    String name = rs.getString("name");
                    String row= name;
                    ans = ans+row+";;";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        
        else if(uri.equals("/addmovies"))
        {
            String category=parms.getProperty("category");
            String mname=parms.getProperty("mname");
            String director = parms.getProperty("director");
            String cast = parms.getProperty("cast");
            String id = parms.getProperty("id");
            String tid=parms.getProperty("tid");
           String name = saveFileOnServerWithRandomName(files,parms,"f2","src/uploads/");
           
            try 
            {
                ResultSet rs = DBLoader.executeQuery("select * from movies");
                rs.moveToInsertRow();
                rs.updateString("movie_name", mname);
                rs.updateString("director",director);
                rs.updateString("cast",cast);
                rs.updateString("youtube_id",id);
                rs.updateString("trailer",tid);
                rs.updateString("photo","src/uploads/"+name);
                rs.updateString("category",category);
                rs.insertRow();
                
                res = new Response(HTTP_OK, "text/plain", "success");
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        
        else if(uri.equals("/fetchmovies"))
        {
            String category = parms.getProperty("category");
            String ans ="";
            try 
            {
                 ResultSet rs = DBLoader.executeQuery("select * from movies where category = '"+category+"'");
                 while (rs.next())
                 {
                     int id = rs.getInt("id");
                     String m_name = rs.getString("movie_name");
                     String photo = rs.getString("photo");
                     String row = id+"$"+m_name+"$"+photo;
                     ans=ans+row+";;";
                     
                 }
                 
                 res = new Response(HTTP_OK, "text/plain", ans);
                
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
           
            
        }
        
        else if(uri.equals("/loadmovie"))
        {
            int id = Integer.parseInt(parms.getProperty("id"));
            String ans="";
            try {
                
            
            ResultSet rs = DBLoader.executeQuery("select * from movies where id="+id);
            if(rs.next())
            {
                String mname=rs.getString("movie_name");
                String director = rs.getString("director");
                String cast = rs.getString("cast");
                String photo = rs.getString("photo");
                String yid = rs.getString("youtube_id");
                String tid = rs.getString("trailer");
                
                ans=mname+";;"+director+";;"+cast+";;"+photo+";;"+yid+";;"+tid;
                 res = new Response(HTTP_OK, "text/plain", ans);
                
            }
            else
            {
                res = new Response(HTTP_OK, "text/plain", "error");
            }
            } 
            catch (Exception e) 
            {
                 e.printStackTrace();
            }
        }
        
        else if(uri.equals("/search"))
        {
            String ans = "";
            String name = parms.getProperty("name");
            System.out.println("sname----"+name);
            try 
            {
               ResultSet rs = DBLoader.executeQuery("select * from movies where movie_name like '"+name+"%'");
               
                
               
               while (rs.next())
               {
                   int id = rs.getInt("id");
                   String name1 = rs.getString("movie_name");
                   System.out.println("ans1-----"+name1);
                   String photo  =rs.getString("photo");
              
                   String row = id+"$"+name1+"$"+photo;
                   ans = ans+row+";;";
               }
                System.out.println("myserver------"+ans);
               res = new Response(HTTP_OK, "text/plain", ans);
               
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        
        return res;
    }
//    public static void main(String[] args) {
//        try
//        {
//           myServer obj =new myServer(9000);
//           Thread.sleep(1000000000);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
    
}
