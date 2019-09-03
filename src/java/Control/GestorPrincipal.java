package Control;


public class GestorPrincipal {
    
    private static GestorPrincipal gesPrincipal; 
    
    public static GestorPrincipal getInstancia(){
        if(gesPrincipal==null){
            gesPrincipal=new GestorPrincipal();
        }
        return gesPrincipal;
    }
    
    public static boolean isLogin(String usu, String cla){
        System.out.println(usu);
        if (usu.equals("1022")){
            return true;
        }
        return false;
    }   
}
