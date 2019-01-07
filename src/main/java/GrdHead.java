import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


//Grd文件头
public class GrdHead {

    private short nx;
    private short ny;
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double z1;
    private double z2;

    public GrdHead(String path){
        this.readHeadFile(path);
    }

    public static HashMap getGrdHead(InputStream in){
        TileSplitDataInputStream mydis = null;
        HashMap map = new HashMap();
        try {
            mydis = new TileSplitDataInputStream(in);
            long i = mydis.skip(4);
            map.put("nx",mydis.readShort());
            map.put("ny",mydis.readShort());
            map.put("x1",mydis.readDouble());
            map.put("x2",mydis.readDouble());
            map.put("y1",mydis.readDouble());
            map.put("y2",mydis.readDouble());
            map.put("z1",mydis.readDouble());
            map.put("z2",mydis.readDouble());

        }catch (Exception e){
            return null;
        }

        return map;
    }
    public void readHeadFile(String path) {
        TileSplitDataInputStream mydis = null;
        try {
            mydis = new TileSplitDataInputStream(new FileInputStream(path));
            long i = mydis.skip(4);
            this.nx = mydis.readShort();
            this.ny = mydis.readShort();
            this.x1 = mydis.readDouble();
            this.x2 = mydis.readDouble();
            this.y1 = mydis.readDouble();
            this.y2 = mydis.readDouble();
            this.z1 = mydis.readDouble();
            this.z2 = mydis.readDouble();
            System.out.println(nx);
            System.out.println(ny);
            System.out.println(x1);
            System.out.println(x2);
            System.out.println(y1);
            System.out.println(y2);
            System.out.println(z1);
            System.out.println(z2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                mydis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}