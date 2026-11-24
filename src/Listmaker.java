import java.util.ArrayList;
import java.util.Scanner;
public class Listmaker {
    private static ArrayList<String> lines = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    private String line = "";
    static void main() {
        String cmd = ""; /// where letters go
        boolean done = false;
        do{
            viewItem();
            cmd = SafeInput.getRegExString(in, "[A]dd [I]nsert [D]elete [V]iew [Q]uit","[AaIiDdVvQq]");
            cmd = cmd.toUpperCase();
            switch(cmd)
            {

                case "A":
                    addItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "V":
                    viewItem();
                    break;
                case "Q":
                    if(SafeInput.getYNConfirm(in, "do you want to quit?"))
                        System.exit(0);
                    break;
            }
        }while(!done);
    }
    private static void addItem() {
        lines.add(SafeInput.getNonZeroLenString(in,"add yer words... \n or numbers...\n or symbols"));
    }
    private static void insertItem(){
        lines.set(SafeInput.getRangedInt(in, "Enter the item to overwrite", 1, lines.size())-1 ,SafeInput.getNonZeroLenString(in,"Overwrite with"));
    }
    private static void deleteItem()
    {
        if(!lines.isEmpty())
        {
            lines.remove(SafeInput.getRangedInt(in, "Enter the item to delete", 1, lines.size())-1);
        }
        else
        {
            System.out.println("list is empty, chief");
        }
    }
    private static void viewItem()
    {
        System.out.println("##################################################");
        if(!lines.isEmpty())
        {
            int itemNum = 1;
            for (String line:lines)
            {
                System.out.println(itemNum + ". " + line);
                itemNum += 1;
            }
        }
        else
        {
            System.out.println("Nothing in the list, pal");
        }
        System.out.println("##################################################");
    }
}
