package serv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class fileupload
 */

@WebServlet("/fileupload")
@MultipartConfig
public class fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileupload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		int i;
		 java.io.PrintWriter out = response.getWriter( );
		 out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         final Part filePart = request.getPart("file");
         InputStream filecontent = filePart.getInputStream();
         BufferedReader reader = new BufferedReader(new InputStreamReader(filecontent));
//         int read = 0;
         final byte[] bytes = new byte[4000];
         StringBuilder outstring = new StringBuilder();
//
//         while ((read = filecontent.read(bytes)) != -1) {
//             out.write(bytes, 0, read);
//         }
       //  while((i = filecontent.read(bytes))!=-1) {
             
             // converts integer to character
             //c = (char)i;
             //
             // prints character
             //System.out.print(c);
         //    out.println((char)(filecontent.read()));
          //}
         String line;
         while ((line = reader.readLine()) != null) {
             outstring.append(line);
         }
         out.println(outstring);
         reader.close();
         
         //while((i = filecontent.read(bytes))!=-1)
           //out.println((char)(filecontent.read()));
//         out.println((char)(filecontent.read()));
//         out.println((char)(filecontent.read()));
         
         out.println("</body>");
         out.println("</html>");
	}

}
