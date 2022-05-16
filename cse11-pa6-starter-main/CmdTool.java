import java.util.Arrays;

interface Command{
    String[] execute(String[] data);
}

class Sum implements Command{
    public String[] execute(String[] data){
        int sum = 0;
        for(int i = 0; i < data.length; i += 1){
            sum += Integer.parseInt(data[i]);
        }
        String[] result = {Integer.toString(sum)};
        return result;
    }
}
class Product implements Command{
    public String[] execute(String[] data){
        int product = 1;
        for(int i = 0; i < data.length; i += 1){
            product *= Integer.parseInt(data[i]);
        }
        String[] result = {Integer.toString(product)};
        return result;
    }
}
class Mean implements Command{
    public String[] execute(String[] data){
        double mean = 0;
        for(int i = 0; i < data.length; i += 1){
            mean += Integer.parseInt(data[i]);
        }
        String[] result = {"" + mean/data.length};
        return result;
    }
}
class Max implements Command{
    public String[] execute(String[] data){
        String max = "";
        if(data.length > 1){
            int m = Integer.parseInt(data[1]);
            for(int i = 0; i < data.length; i += 1){
                if(m < Integer.parseInt(data[i])){
                    m = Integer.parseInt(data[i]);
                }
            }
            max = Integer.toString(m);
        }
        String[] result = {max};
        return result;
    }
}
class Min implements Command{
    public String[] execute(String[] data){
        String min = "";
        if(data.length > 1){
            int m = Integer.parseInt(data[1]);
            for(int i = 0; i < data.length; i += 1){
                if(m > Integer.parseInt(data[i])){
                    m = Integer.parseInt(data[i]);
                }
            }
            min = Integer.toString(m);
        }
        String[] result = {min};
        return result;
    }
}
class Count implements Command{
    public String[] execute(String[] data){
        int count = data.length;
        String[] result = {Integer.toString(count)};
        return result;
    }
}
class Positive implements Command{
    public String[] execute(String[] data){
        int count = 0;
        for(int i = 0; i < data.length; i += 1){
            if(Integer.parseInt(data[i]) > 0){
                count += 1;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for(int i = 1; i < data.length; i += 1){
            if(Integer.parseInt(data[i]) > 0){
                result[index] = data[i];
                index += 1;
            }
        }
        return result;
    }
}
class Negative implements Command{
    public String[] execute(String[] data){
        int count = 0;
        for(int i = 0; i < data.length; i += 1){
            if(Integer.parseInt(data[i]) < 0){
                count += 1;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for(int i = 0; i < data.length; i += 1){
            if(Integer.parseInt(data[i]) < 0){
                result[index] = data[i];
                index += 1;
            }
        }
        return result;
    }
}
class Greater implements Command{
    String compare;
    Greater(String compare){
        this.compare = compare;
    }
    public String[] execute(String[] data){
        int count = 0;
        for(String str: data){
            if(Integer.parseInt(str) > Integer.parseInt(compare)){
                count += 1;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for(String str: data){
            if(Integer.parseInt(str) > Integer.parseInt(compare)){
                result[index] = str;
                index += 1;
            }
        }
        return result;
    }
}
class Lesser implements Command{
    String compare;
    Lesser(String compare){
        this.compare = compare;
    }
    public String[] execute(String[] data){
        int count = 0;
        for(String str: data){
            if(Integer.parseInt(str) < Integer.parseInt(compare)){
                count += 1;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for(String str: data){
            if(Integer.parseInt(str) < Integer.parseInt(compare)){
                result[index] = str;
                index += 1;
            }
        }
        return result;
    }
}
class Equal implements Command{
    String compare;
    Equal(String compare){
        this.compare = compare;
    }
    public String[] execute(String[] data){
        int count = 0;
        for(int i = 0; i < data.length; i ++){
            if(data[i].equals(compare)){
                count += 1;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for(int i = 0; i < data.length; i ++){
            if(data[i].equals(compare)){
                result[index] = data[i];
                index += 1;
            }
        }
        return result;
    }
}
class CmdList implements Command{
    Command[] commands;
    CmdList(Command[]commands){
        this.commands = commands;
    }
    public String[] execute(String[] data){
        String[] result = CmdTool.processCmdData(data);
        for(Command c: commands){
            result = c.execute(result);
        }
        return result;
    }
}

class CmdTool{
    // Prints the contents of a String[] on one line
    static void printArray(String[] data){
        String print = "";
        for(String str: data){
            print += str + " ";
        }
        System.out.println(print);
    }
    static boolean isCmd(String str){
        if(str.indexOf("a") >=0 || str.indexOf("e") >=0 || str.indexOf("i") >=0 || str.indexOf("u") >=0 || str.indexOf("l") >=0)
        return true; else return false;
    }
    // Returns the number of command options on the command line
    static int countCmds(String[] args){
        int count = 0;
        for(String str: args){
            if(isCmd(str)){
                count += 1;
            }
        }
        return count;
    }
    // Returns a String[] containing only the integer data
    static String[] processCmdData(String[] args){
        int start = 0;
        for(int i = 0; i < args.length; i += 1){
            if(isCmd(args[i])){
                start += 1;
                if(args[i].equals("greater") || args[i].equals("lesser") || args[i].equals("equal")){
                    start += 1;
                }
            }
        }
        return Arrays.copyOfRange(args, start, args.length);
    }
    // Returns a Command object corresponding to a command option
    static Command processCmd(String[] args){
        if(args[0].equals("sum")){
            return new Sum();
        }
        else if(args[0].equals("product")){
            return new Product();
        }
        else if(args[0].equals("mean")){
            return new Mean();
        }
        else if(args[0].equals("max")){
            return new Max();
        }
        else if(args[0].equals("min")){
            return new Min();
        }
        else if(args[0].equals("positive")){
            return new Positive();
        }
        else if(args[0].equals("negative")){
            return new Negative();
        }
        else if(args[0].equals("count")){
            return new Count();
        }
        else if(args[0].equals("greater")){
            return new Greater(args[1]);
        }
        else if(args[0].equals("lesser")){
            return new Lesser(args[1]);
        }
        else if(args[0].equals("equal")){
            return new Equal(args[1]);
        }
        else if(args[0].equals("-l") || args[0].equals("-list")){
            return new CmdList(processCmdList(args));
        }
        else{
            return null;
        }
    }
    // Returns a Command[] containing Command objects corresponding
    // to all the command options on the command line
    static Command[] processCmdList(String[] args){
        Command[] commands = new Command[countCmds(args) - 1];
        String[] toCommand = args;
        int index = 0;
        for(int i = 1; i < args.length; i += 1){
            if(isCmd(args[i])){
                commands[index] = processCmd(Arrays.copyOfRange(toCommand, i, toCommand.length));
                index += 1;
                if(args[i].equals("greater") || args[i].equals("lesser") || args[i].equals("equal")){
                    i += 1;
                }
            }
        }
        return commands;
    }

    public static void main(String[] args){
        String[] data = processCmdData(args);
        Command c = processCmd(args);
        printArray(c.execute(data));
   }
}