package Pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


class PackUnpack
{
  FileOutputStream fobj1;
  FileInputStream fobj2;
  
  public int Unpack(String IPfile)
  {
    try
    {
      File obj1=new File(IPfile);
      if(!obj1.exists())
      {
    	  return -1;
      }
      this.fobj2 = new FileInputStream(IPfile);
      byte[] magic = new byte[10];
      byte[] b1 = new byte[100];
      
      int ret = 0;


      
      this.fobj2.read(magic);
      String str = new String(magic);

      
      if (!str.equals("Deepraj"))
      {
        return -1;
      }
      while ((ret = this.fobj2.read(b1)) != -1)
      {
        
        str = new String(b1);
        String[] strarr = str.split("\\s+");
        int size = Integer.valueOf(strarr[1]).intValue();
        File f1 = new File(strarr[0]);
        f1.createNewFile();
        this.fobj1 = new FileOutputStream(strarr[0]);
        byte[] b2 = new byte[size];
        this.fobj2.read(b2);
        this.fobj1.write(b2);
        
        this.fobj1.close();
      } 
      this.fobj2.close();
    }
    catch (Exception exception) {}


    
    return 1;
  }

  
  public int Pack(String Dir, String OPfile) 
  {
    int k = 0;
    
    String[] ext = { "txt", "cpp", "c", "java" };
    //System.out.println("jeetshah11".length());



    
    try 
    {
      File obj = new File(Dir);
      if (!obj.exists())
      {
        return -2;
      }
      this.fobj1 = new FileOutputStream(OPfile);
      this.fobj1.write("Deepraj".getBytes());
      File[] farr = obj.listFiles();
      for (int j = 0; j < farr.length; j++)
      {

        
        String[] arr = farr[j].getName().split("\\.");
        
        for (k = 0; k < ext.length; k++) 
        {

          
          if (arr[1].equals(ext[k])) 
          {
            break;
          }
        } 



        
        if (k != ext.length) 
        {


          
          this.fobj2 = new FileInputStream(String.valueOf(Dir) + "\\" + farr[j].getName());
          String str = String.format("%-99s\n", new Object[] { String.valueOf(farr[j].getName()) + " " + String.valueOf(farr[j].length()) });
          this.fobj1.write(str.getBytes()); 
          int i;
          while ((i = this.fobj2.read()) != -1) 
          {

            
            System.out.println((char)i);
            
            this.fobj1.write(i);
          } 

          
          this.fobj2.close();
        } 
      }  this.fobj1.close();

    
    }
    catch (Exception exception) 
    {
    	
    }



    
    return 1;
  }
}
