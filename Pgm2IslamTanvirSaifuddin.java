

import java.io.*;
import java.util.*;
/**
 *
 * @author shuvo
 */
public class Pgm2IslamTanvirSaifuddin{

    /**
     * @param args the command line arguments
     */
    static String getAlphaNumericString() 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(9); 
  
        for (int i = 0; i < 9; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }
    
    
    private static HashMap<String, User> init() throws IOException {
		// initialize our user objects
                
		Random rand = new Random(); 
	        ArrayList<User> alluser= new ArrayList<User>();
                
		// initialize of hashmap
		HashMap<String, User> map = new HashMap<String, User>();
                int i;
                 String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz"; 
                 // create StringBuffer size of AlphaNumericString 
                StringBuilder sb = new StringBuilder(9);
                FileWriter out = new FileWriter("Verification_code.txt");
		// assign each student id as key and the student objects as values on
                for(i=0;i<100;i++){
                    //for generating identifier
                    String Identifier = UUID.randomUUID().toString();
                    Identifier = Identifier.substring(0, 12).replace("-", "").toString();
                    
                    if(i==20)
                    {
                        Identifier="abcdef12345";
                        alluser.add( new User(getAlphaNumericString(), getAlphaNumericString(),rand.nextInt(70)+20,"Male",getAlphaNumericString(),getAlphaNumericString(),Identifier));
                    }
                    if(i%2==1){
                alluser.add( new User(getAlphaNumericString(), getAlphaNumericString(),rand.nextInt(70)+20,"Male",getAlphaNumericString(),getAlphaNumericString()));
                    }
                // our hashmap
                    else{
                alluser.add( new User(getAlphaNumericString(), getAlphaNumericString(),rand.nextInt(70)+20,"Female",getAlphaNumericString(),getAlphaNumericString()));

                    }
                
		map.put(""+i+"",alluser.get(i) );
                out.write(Identifier+"\n");
                }
                out.close();
		//System.out.println(i);

		return map;
	}
    
     // Function to perform breadth first search
    public static int breadthFirstSearch(int[][] matrix, int source){
        boolean[] visited = new boolean[matrix.length];
        visited[source-1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        System.out.println("The breadth first order is");
        while(!queue.isEmpty()){
            System.out.print(queue.peek()+ " ->");
            int x = queue.poll();
            int i;
            for(i=0; i<matrix.length;i++){
                if(matrix[x-1][i] == 1 && visited[i] == false){
                    queue.add(i+1);
                    visited[i] = true;
                }
            }
        }
        
        System.out.println();
        return 0;
    }
    
    
    static int case1_1(int FirstNamePrivacy[][],int FirstNameAnonymity[][],int Authenticity[][],String user_id, int id, int user_id1,HashMap<String, User> map)
    {
                if(Authenticity[user_id1][id]==0)
                {
                    System.out.println ("Due to authenticity issue, this data can't be shown.\n");
                }
                else if (FirstNamePrivacy[user_id1][id]==11 && FirstNameAnonymity[user_id1][id]==1) 
                {
                    System.out.println("Data is extremly hidden\n");
                }
                else if (FirstNamePrivacy[user_id1][id]==10 && FirstNameAnonymity[user_id1][id]==1)
                {
                    System.out.println ("As you are Anonymous User, you are NOT ALLOWED to see Information that carries Idetification. You may Try to see other Information\n");
                }
                else if (FirstNamePrivacy[user_id1][id]==10 && FirstNameAnonymity[user_id1][id]==0)
                {
                    System.out.println ("First Name Is: "+map.get(user_id).getFirstName()+"\n");
                }
        
        return 0;
    }
    
    
    static int case1_2(int LastNamePrivacy[][], int LastNameAnonymity[][],int Authenticity[][], String user_id, int id, int user_id1, HashMap<String, User>map)
    {
                if(Authenticity[user_id1][id]==0)
                {
                    System.out.println ("Due to authenticity issue, this data can't be shown.\n");
                }
                else if (LastNamePrivacy[user_id1][id]==11 && LastNameAnonymity[user_id1][id]==1) 
                {
                 System.out.println("Data is extremly hidden\n");
                }
                else if (LastNamePrivacy[user_id1][id]==10 && LastNameAnonymity[user_id1][id]==1)
                {
                System.out.println ("As you are Anonymous User, you are NOT ALLOWED to see Information that carries Idetification. You may Try to see other Information\n");
                }
                else if (LastNamePrivacy[user_id1][id]==10 && LastNameAnonymity[user_id1][id]==0)
                {
                 System.out.println ("Last Name Is: "+map.get(user_id).getLastName()+"\n");
                }
                
        return 0;
    }
    
    
    static int case1_3(int AgePrivacy[][], int AgeAnonymity[][],int Authenticity[][], String user_id, int id,int user_id1,HashMap<String, User> map)
    {
                if(Authenticity[user_id1][id]==0)
                {
                    System.out.println ("Due to authenticity issue, this data can't be shown.\n");
                }
                else if (AgePrivacy[user_id1][id]==11 && AgeAnonymity[user_id1][id]==1) 
                {
                    System.out.println("Data is extremly hidden\n");
                }
                else if (AgePrivacy[user_id1][id]==10 && AgeAnonymity[user_id1][id]==1)
                {
                    System.out.println ("Age Is: "+map.get(user_id).getAge()+"\n");
                }
                else if (AgePrivacy[user_id1][id]==10 && AgeAnonymity[user_id1][id]==0)
                {
                    System.out.println ("Age Is: "+map.get(user_id).getAge()+"\n");
                }
        return 0; 
    }
    
    
    static int case1_4(int GenderPrivacy[][], int GenderAnonymity[][],int Authenticity[][], String user_id,int id,int  user_id1, HashMap<String, User>map)
    {
                if(Authenticity[user_id1][id]==0)
                {
                    System.out.println ("Due to authenticity issue, this data can't be shown.\n");
                }
                else if (GenderPrivacy[user_id1][id]==11 && GenderAnonymity[user_id1][id]==1) 
                {
                    System.out.println("Data is extremly hidden\n");
                }
                else if (GenderPrivacy[user_id1][id]==10 && GenderAnonymity[user_id1][id]==1)
                {
                    System.out.println ("Gender :"+map.get(user_id).getGender()+"\n");
                }
                else if (GenderPrivacy[user_id1][id]==10 && GenderAnonymity[user_id1][id]==0)
                {
                    System.out.println ("Gender :"+map.get(user_id).getGender()+"\n");
                }
        return 0;
    }
    
    
     static int case1_5(int EmailPrivacy[][], int EmailAnonymity[][], int Authenticity[][], String user_id,int id, int user_id1, HashMap<String, User>map)
     {
                if(Authenticity[user_id1][id]==0)
                {
                    System.out.println ("Due to authenticity issue, this data can't be shown.\n");
                }
                else if (EmailPrivacy[user_id1][id]==11 && EmailAnonymity[user_id1][id]==1) 
                {
                 System.out.println("Data is extremly hidden\n");
                }
                else if (EmailPrivacy[user_id1][id]==10 && EmailAnonymity[user_id1][id]==1)
                {
                System.out.println ("Email Is: "+map.get(user_id).getEmail()+"\n");
                }
                else if (EmailPrivacy[user_id1][id]==10 && EmailAnonymity[user_id1][id]==0)
                {
                 System.out.println ("Email Is: "+map.get(user_id).getEmail()+"\n");
                }
         return 0; 
     }
     
     
            static int case1_6(int SnsPrivacy[][],int SnsAnonymity[][],int Authenticity[][], String user_id,int id, int user_id1, HashMap<String, User>map)
            {
                if(Authenticity[user_id1][id]==0)
                {
                    System.out.println ("Due to authenticity issue, this data can't be shown.\n");
                }
                else if (SnsPrivacy[user_id1][id]==11 && SnsAnonymity[user_id1][id]==1) 
                {
                 System.out.println("Data is extremly hidden\n");
                }
                else if (SnsPrivacy[user_id1][id]==10 && SnsAnonymity[user_id1][id]==1)
                {
                System.out.println ("As you are Anonymous User, you are NOT ALLOWED to see Information that carries Idetification. You may Try to see other Information\n");
                }
                else if (SnsPrivacy[user_id1][id]==10 && SnsAnonymity[user_id1][id]==0)
                {
                 System.out.println ("SNS No.: "+map.get(user_id).getSns()+"\n");
                }
                return 0;
            }
            
            
            
            
            static int case2_1(int FirstNamePrivacy[][],int FirstNameAnonymity[][],int Authenticity[][],int id, HashMap<String, User>map)
            {
                for (int j=0;j<100;j++)
                {
                    if(Authenticity[j][id]==0)
                    {
                        System.out.println("Due to authenticity issue, this data can't be shown.\n");
                    }
                    else if (FirstNamePrivacy[j][id]==10 && FirstNameAnonymity[j][id]==1)
                   {
                        System.out.println ("As you are Anonymous User, you are NOT ALLOWED to see this Information.\n");
                   }
                   else if (FirstNamePrivacy[j][id]==11 && FirstNameAnonymity[j][id]==1)
                   {
                        System.out.println ("Data is hidden for this user.\n");
                   }
                   else if (FirstNamePrivacy[j][id]==10 && FirstNameAnonymity[j][id]==0)
                   {
                         String j1=Integer.toString(j);
                         System.out.println ("First Name Is: "+map.get(j1).getFirstName()+"\n");          
                   }
                }
                return 0;
            }
            
            
            
            static int case2_2(int LastNamePrivacy[][],int LastNameAnonymity[][],int Authenticity[][],int id, HashMap<String, User>map)
            {
                for (int j=0;j<100;j++)
                {
                    if(Authenticity[j][id]==0)
                    {
                        System.out.println("Due to authenticity issue, this data can't be shown.\n");
                    }
                    else if (LastNamePrivacy[j][id]==10 && LastNameAnonymity[j][id]==1)
                    {
                        System.out.println ("As you are Anonymous User, you are NOT ALLOWED to see this Information.\n");
                    }
                    else if (LastNamePrivacy[j][id]==11 && LastNameAnonymity[j][id]==1)
                    {  
                        System.out.println ("Data is hidden for this user.\n");
                    }
                    else if (LastNamePrivacy[j][id]==10 && LastNameAnonymity[j][id]==0)
                    {
                         String j1=Integer.toString(j);
                         System.out.println ("Last Name Is: "+map.get(j1).getLastName()+"\n");          
                    }
                }
                return 0;
            }
             
             
             
            static int case2_3(int AgePrivacy[][],int AgeAnonymity[][],int Authenticity[][],int id, HashMap<String, User>map)
            {
                for (int j=0;j<100;j++)
                {
                    if(Authenticity[j][id]==0)
                    {
                        System.out.println("Due to authenticity issue, this data can't be shown.\n");
                    }
                    else if (AgePrivacy[j][id]==10 && AgeAnonymity[j][id]==1)
                    {
                        String j1=Integer.toString(j);
                        System.out.println ("Age is: "+map.get(j1).getAge()+". Due to anonymity issue, user id can't be displayed.\n");          
                    }
                    else if (AgePrivacy[j][id]==11 && AgeAnonymity[j][id]==1)
                    {
                        System.out.println ("Data is hidden for this user.\n");          
                    }
                    else if (AgePrivacy[j][id]==10 && AgeAnonymity[j][id]==0)
                    {
                        String j1=Integer.toString(j);
                        System.out.println ("Age of "+map.get(j1).getFirstName()+" is: "+map.get(j1).getAge()+"\n");          
                    }
                }
                return 0;
            }
             
             
             
            static int case2_4(int GenderPrivacy[][],int GenderAnonymity[][],int Authenticity[][],int id, HashMap<String, User>map)
            {
                for (int j=0;j<100;j++)
                {
                    if(Authenticity[j][id]==0)
                    {
                        System.out.println("Due to authenticity issue, this data can't be shown.\n");
                    }
                    else if (GenderPrivacy[j][id]==10 && GenderAnonymity[j][id]==1)
                    {
                        String j1=Integer.toString(j);  
                        System.out.println ("Gender is: "+map.get(j1).getGender()+". Due to anonymity issue, user id can't be displayed.\n");          
                    }
                    else if (GenderPrivacy[j][id]==11 && GenderAnonymity[j][id]==1)
                    {
                        System.out.println ("Data is hidden for this user.\n");          
                    }
                    else if (GenderPrivacy[j][id]==10 && GenderAnonymity[j][id]==0)
                    {
                        String j1=Integer.toString(j);
                        System.out.println ("Gender of "+map.get(j1).getFirstName()+" is: "+map.get(j1).getGender()+"\n");          
                    }
                }
                return 0;
            }
             
             
             
            static int case2_5(int EmailPrivacy[][],int EmailAnonymity[][],int Authenticity[][],int id, HashMap<String, User>map)
            {
                for (int j=0;j<100;j++)
                {
                    if(Authenticity[j][id]==0)
                    {
                        System.out.println("Due to authenticity issue, this data can't be shown.\n");
                    }
                    else if (EmailPrivacy[j][id]==10 && EmailAnonymity[j][id]==1)
                    {
                        String j1=Integer.toString(j);  
                        System.out.println ("Email ID is: "+map.get(j1).getEmail()+". Due to anonymity issue, user id can't be displayed.\n");          
                    }
                    else if (EmailPrivacy[j][id]==11 && EmailAnonymity[j][id]==1)
                    {
                        System.out.println ("Data is hidden for this user.\n");          
                    }
                    else if (EmailPrivacy[j][id]==10 && EmailAnonymity[j][id]==0)
                    {
                         String j1=Integer.toString(j);
                         System.out.println ("Email ID of "+map.get(j1).getFirstName()+" is: "+map.get(j1).getEmail()+"\n");          
                    }
                }
                return 0;
            }
             
             
             
             static int case2_6(int SnsPrivacy[][],int SnsAnonymity[][],int Authenticity[][],int id, HashMap<String, User>map)
             {
                for (int j=0;j<100;j++)
                {
                    if(Authenticity[j][id]==0)
                    {
                        System.out.println("Due to authenticity issue, this data can't be shown.\n");
                    }
                    else if (SnsPrivacy[j][id]==10 && SnsAnonymity[j][id]==1)
                    {
                        System.out.println ("As you are Anonymous User, you are NOT ALLOWED to see Information.\n");     
                    }
                    else if (SnsPrivacy[j][id]==11 && SnsAnonymity[j][id]==1)
                    {
                        System.out.println ("Data is hidden for this user.\n");     
                    }
                    else if (SnsPrivacy[j][id]==10 && SnsAnonymity[j][id]==0)
                    {
                         String j1=Integer.toString(j);
                         System.out.println ("SNS No.of "+map.get(j1).getFirstName()+" is: "+map.get(j1).getSns()+"\n");          
                    }
                }
                return 0;
            }

    public static void dfs(int i, int[][] graph, boolean[] visited) {
    if(!visited[i]){        
        visited[i] = true; // Mark node as "visited"
        System.out.print(i + "->");

        for (int j = 0; j < graph[i].length; j++) {
            if (graph[i][j]==1 && !visited[j]) {   
                dfs(j, graph, visited); // Visit node
            }
        }
    }   
}
    
    static void depthFirstSearch(int[][] graph, int source){
    boolean [] visited = new boolean[graph.length];
    int count = 0;
    for(int i = 0; i < graph.length; i++) {
        if(!visited[i]) {
            
            dfs(i,graph,visited);
            System.out.println();
            ++count;
        }
    }
    System.out.println("Total number of Components: " + count);
    }
    
    public static void WriteGraphToTextFile(int graph[][], String s,int collumn, int row) throws IOException
    {
        FileWriter out = new FileWriter(s+".txt");
        
        for(int i=0; i<collumn;i++)
        {
            for(int j=0;j<row;j++)
            {
                
                out.write(" "+graph[i][j]);
                //System.out.print(" "+graph[i][j]);
            }
            out.write("\n");
            //System.out.println();
        }
        //System.out.println();
        out.close();
    }
    
    
    public static void CreateGraph(int graph[][], String s,int collumn, int row) throws IOException
    {
         Random rand = new Random(); 
         int i,j;
        
        FileWriter out = new FileWriter(s+".txt");
        //System.out.println("Before : ");
        for(i=0; i<collumn;i++)
        {
            for(j=0;j<row;j++)
            {
                if(i==j)
                {
                    graph[i][j]=0;
                }
                else
                {
                    int x=rand.nextInt(2);
                    graph[i][j]= (x == 0) ? 0 : 1;
                }
                
                out.write(" "+graph[i][j]);
                //System.out.print(" "+graph[i][j]);
            }
            out.write("\n");
            //System.out.println();
        }
        //System.out.println();
        out.close();
    }
    
    
    public static void CreateAuthenticGraph(int graph[][], String s,int collumn, int row) throws IOException
    { 
         int i,j;
        
        FileWriter out = new FileWriter(s+".txt");
        //System.out.println("Before : ");
        for(i=0; i<collumn;i++)
        {
            for(j=0;j<row;j++)
            {
                if(i==j)
                {
                    graph[i][j]=1;
                }
                else if((j%5)==0)
                {
                   graph[i][j]=0; 
                }
               
                else
                {
                    graph[i][j]= 1;
                }
                
                out.write(" "+graph[i][j]);
                //System.out.print(" "+graph[i][j]);
            }
            out.write("\n");
            //System.out.println();
        }
        //System.out.println();
        out.close();
    }
    
    
    
    public static void CreateUser2GroupGraph(int graph[][], String s,int row, int collumn) throws IOException
    {
         Random rand = new Random(); 
         int i,j,k=0;
        
        FileWriter out = new FileWriter(s+".txt");
        //System.out.println("Before : ");
        for(i=0; i<row;i++)
        {
            for(j=0;j<collumn;j++)
            {
                if((i%10)==0)
                {
                    graph[i][j]=0;
                }
                else
                {
                    if(i<80)
                    {
                        graph[i][k]=1;
                        k++;
                        if(k>9)
                        {
                            k=0;
                        }
                        break;
                    }
                    else
                    {
                        
                       int x=rand.nextInt(2);
                       graph[i][j] = (x==0) ? 0 : 1;
                       out.write(" "+graph[i][j]);
                    }
                }
                
                out.write(" "+graph[i][j]);
                //System.out.print(" "+graph[i][j]);
            }
            out.write("\n");
            //System.out.println();
        }
        //System.out.println();
        out.close();
    }
    
    
    public static void CreateGroupGraph(int graph[][], String s,int collumn, int row) throws IOException
    {
         Random rand = new Random(); 
         int i,j;
        
        FileWriter out = new FileWriter(s+".txt");
        //System.out.println("Before : ");
        for(i=0; i<collumn;i++)
        {
            for(j=0;j<row;j++)
            {
                if(i==j)
                {
                    graph[i][j]=0;
                }
                else if(i+7==j)
                {
                    graph[i][j]=1;
                }
                else graph[i][j]=0;
                
                out.write(" "+graph[i][j]);
                //System.out.print(" "+graph[i][j]);
            }
            out.write("\n");
            //System.out.println();
        }
        //System.out.println();
        out.close();
    }
    
    public static void CreateAuthenticGroupGraph(int graph[][], String s,int collumn, int row) throws IOException
    {
         Random rand = new Random(); 
         int i,j;
        
        FileWriter out = new FileWriter(s+".txt");
        //System.out.println("Before : ");
        for(i=0; i<collumn;i++)
        {
            for(j=0;j<row;j++)
            {
                if(i==j)
                {
                    graph[i][j]=1;
                }
                else if(i+7==j)
                {
                    graph[i][j]=0;
                }
                else graph[i][j]=1;
                
                out.write(" "+graph[i][j]);
            }
            out.write("\n");
        }
        //System.out.println();
        out.close();
    }
   
    
    
    public static int[][] PrepareGroupWiseUserList(int UserGroup[][])
    {
        int GroupWiseUserList[][]= new int [10][100];
        
        int count=0;
        
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<100;j++)
            {
                GroupWiseUserList[i][j]=-1;
            }
            
        }
        
        //prepare group wise user list in a 2d int matrix
        //traverse by columns/group. if a user exists for a column/group, add user id to a 2d matrix
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(UserGroup[j][i]==1)  
                {
                    GroupWiseUserList[i][count++]=j; 
                }
                
            }
            
            count=0;
        
        }
         
        return GroupWiseUserList;        
        
    }

    
    
    static int[][] PrepareUserListForGraphOverriding(int i, int j, int[][] UserGroupGraph)
    {
        int UserListForGraphOverriding[][]= new int[2][100];
        
        for(int x=0; x<100;x++)
        {
            UserListForGraphOverriding[0][x]=-1;
            UserListForGraphOverriding[1][x]=-1;
        }

        //user list will be a 2-rowed matrix. first row will contain from-group which will impose privacy/anonymity relation
        //second row will contain to-group on which will privacy/anonymity relation will be imposed

        for(int x=0; x<UserGroupGraph[i].length;x++)
        {
            if(UserGroupGraph[i][x]>=0)
            {
                UserListForGraphOverriding[0][x] = UserGroupGraph[i][x];
            }
        }
        
        for(int x=0; x<UserGroupGraph[j].length;x++)
        {
            if(UserGroupGraph[j][x]>=0)
            {
                UserListForGraphOverriding[1][x] = UserGroupGraph[j][x];
            }
        }
        
        return UserListForGraphOverriding;
    }
    
    
    static int[] GetTrustedUsersList(int id, int[][] PrivacyMatrix, int[][] AnonymityMatrix, HashMap<String, User> map)
    {
        
        int[] trustedUsersList = new int[100];
        int count=0;
        
        //maintain a list for storing trusted users and initialize all its value to -1
        for(int i=0;i<100;i++)
        {
            trustedUsersList[i]=-1;
        }
        
        System.out.println("Your trusted users are : ");
        //if a user has no privacy or anonymity relation to another user, that user is considered as trusted
        for(int i=0;i<100;i++)
        {
                if((PrivacyMatrix[i][id]==0) && (AnonymityMatrix[i][id]==0))
                {
                    trustedUsersList[count++]=i;
                    System.out.println(map.get(Integer.toString(i)).getLastName());
                }
            
        }
        System.out.println();
        
        count=0;
        return trustedUsersList;
        
    }
    
    
    static void GetMostTrustedUsersList(int id, double[][] trustGraph)
    {
        
        int[] trustedUsersList = new int[100];
        
        
        int n = 100; 
        for (int i = 0; i < n-1; i++)
        {
            for (int j = i+1; j < n; j++)
            {
               if (trustGraph[id][i] > trustGraph[id][j]) 
               { 
                    // swap trustGraph[id][j+1] and trustGraph[id][j] 
                    double temp = trustGraph[id][i]; 
                    trustGraph[id][i] = trustGraph[id][j]; 
                    trustGraph[id][j] = temp; 
                    
                    int index = j;
                    trustedUsersList[j]=i;
                    trustedUsersList[i] = index;
                    
                } 
            }
                 
        }
       
       
       System.out.println("Your most trusted users are : \nUser Id Trust Percentage(%)\n");
       int count=0;
       //if a user has no privacy or anonymity relation to another user, that user is considered as trusted
       for(int i=0;i<6;i++)
        {
            if(id!=trustedUsersList[i])
            {
                double trust=100-(trustGraph[id][i]*100);
                System.out.print(trustedUsersList[i]+" ~~~ "+ trust+"%\n");
                count++;
            }
            if(count==5) break;
            
        }
        System.out.println();
        
    }
    
    
    static void GetUntrustedUsersList(int UserId, int[][] PrivacyMatrix, int[][] AnonymityMatrix, HashMap<String, User> map)
    {
        
        int[] UnTrustedUsersList = new int[100];
        int count=0;
        
        //maintain a list for storing untrusted users and initialize all its value to -1
        for(int i=0;i<100;i++)
        {
            UnTrustedUsersList[i]=-1;
        }
        
        System.out.println("Your untrusted users are : "+UserId);
        //if a user has any kind of privacy or anonymity relation to another user, that user is considered as untrusted
        for(int j=0;j<100;j++)
        {
                if((PrivacyMatrix[j][UserId]==1) || (AnonymityMatrix[j][UserId]==1))
                {
                    UnTrustedUsersList[count++]=j;
                    System.out.println(map.get(Integer.toString(j)).getLastName());
                }
            
        }
        
    }
    
    
    static void GetMostUntrustedUsersList(int id, double[][] trustGraph)
    {
        
        int[] trustedUsersList = new int[100];
        
        int n = 100; 
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
               if (trustGraph[id][j] > trustGraph[id][j+1]) 
                { 
                    // swap trustGraph[id][j+1] and trustGraph[id][j] 
                    double temp = trustGraph[id][j]; 
                    trustGraph[id][j] = trustGraph[id][j+1]; 
                    trustGraph[id][j+1] = temp; 
                    
                    int index = j;
                    trustedUsersList[j]=j+1;
                    trustedUsersList[j+1] = index;
                } 
            }
                 
        }
            
        
        System.out.println("Your most untrusted users are : \nUser Id Trust Percentage(%)\n");
        int count=0;
        //if a user has no privacy or anonymity relation to another user, that user is considered as trusted
        for(int i=99;i>=94;i--)
        {
            if(id!=trustedUsersList[i])
            {
                double trust=100-(trustGraph[id][i]*100);
                System.out.print(trustedUsersList[i]+" ~~~ "+ trust+"%\n");
                count++;
            }
            if(count==5) break;
            
        }
        System.out.println();
    }
    
    
    static int[][] DataOverrideAttributeGraph(int[][] UserListForGraphOverriding, int[][] AttributeGraph, int val)
    {
        
        //we have received a user list among which privacy/anonymity relation will be overriden
        //user list contains user id of users
        //the list contain 2 rows
        //first row contains user list from which privacy/anonymity relation will be imposed
        //second row contains user list to which privacy/anonymity relation will be imposed
        for(int i=0;i<UserListForGraphOverriding[0].length;i++)
        {
            for(int j=0;j<UserListForGraphOverriding[1].length;j++)
            {
                if(UserListForGraphOverriding[0][i]!=UserListForGraphOverriding[1][j] && UserListForGraphOverriding[0][i]>=0 && UserListForGraphOverriding[1][j]>=0) 
                {
                    //attribute graph is overriden based on the id of users
                    //index of attribute graphs is similar to user id from user list
                    //we can index the attribute graph on user id of user list 
                    //and we can access privacy information of that specific user
                    AttributeGraph[UserListForGraphOverriding[0][i]][UserListForGraphOverriding[1][j]]=val; 
                }
            }
        }

        
        return AttributeGraph;
    }
    
    
    
    public static int [][] getCrossSectionGraphs(int [][][] graphs, int numberOfGraphs)
    {
        int crossSectionOfGraphs[][]= new int[100][100];
        float totalvalue=0;
        float score=0;
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                totalvalue=0;
                for(int k=0;k< numberOfGraphs;k++)
                {
                    totalvalue+=graphs[k][i][j];
                }
                score = (float) (totalvalue/ numberOfGraphs);
                if(score>0.95)
                {
                   crossSectionOfGraphs[i][j]=0;
                  // System.out.print(score+" "+crossSectionOfGraphs[i][j]);
                }
                else
                {
                   crossSectionOfGraphs[i][j]=1;
                   //System.out.print(score+" "+crossSectionOfGraphs[i][j]);
                }
            }
        }
       return crossSectionOfGraphs; 
    }
    
    //computes a trust graph based users' data in privacy, anonymity and authenticity graphs
    public static double [][] getStronglyTrusted(int [][][] graphs)
    {
        double StronglyTrustedGraphs[][]= new double[100][100];
        double privacyValue=0,AnonymityValue=0,AuthenticityValue=0,totalvalue=0;
        int[] from_groups = new int[10];
        int[] to_groups = new int[10];
        boolean same_group = false;
        double score=0;
        int count=0;
        
        for(int z=0;z<10;z++)
        {
            from_groups[z]=-1;
            to_groups[z]=-1;
        }
        
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(i!=j)
                {
                    for(int x=0;x<10;x++)
                    {
                        if(graphs[13][i][x]==1) from_groups[count++] = x;       
                    }
                    count=0;
                    for(int y=0;y<10;y++)
                    {
                        if(graphs[13][j][y]==1) to_groups[count++] = y;       
                    }
                    count = 0;
                    
                    for(int w=0;w<10;w++)
                    {
                        for(int z=0;z<10;z++)
                        {
                            if(from_groups[w]!=-1 && to_groups[z]!=-1 && from_groups[w]==to_groups[z])
                            {
                                same_group=true;
                                break;
                            } 
                        }
                        
                    }
                    
                    totalvalue=0;
                    privacyValue=0;
                    AnonymityValue=0;
                    AuthenticityValue=0;
                    //k is for each graph
                    for(int k=0;k<13;k++)
                    {
                        if(k==12)
                        {
                            //calculate authenticity score
                            //taking inverse of authentictiy value in order to facilitate the calculation of trust value
                            AuthenticityValue=graphs[12][i][j];
                            //System.out.println("authenticity "+ graphs[12][i][j]);
                        }
                        //calculate privacy score
                        else if(k<7){
                            double temp_privacy_val=((graphs[k][i][j]%10)==0)? 1:0;
                            privacyValue+=temp_privacy_val;
                        }
                        //calculate anonymity score
                        else if(k>=7 && 7<12)
                        {
                            double temp_Anonymity_val=(graphs[k][i][j]==0)? 1:0;
                            AnonymityValue+=graphs[k][i][j];
                        }
                        
                        
                         
                    }
                    //if users belong to same_group, increase the value by 20%
                    if(same_group)
                    {
                       privacyValue*=1.2;
                       AnonymityValue*=1.2;
                       AuthenticityValue*=1.2;
                    }
                    //calculating trust value from privacy, anonymity and authenticity values 
                    //the closer the trust value is to 0, the more trusted the users are
                    //the closer the trust value is to 1, the more untrusted the users are
                    totalvalue= privacyValue+(1.4*AnonymityValue)+(AuthenticityValue*7);
                    
                    //if total score exceeds 21(21 is max value, we reset is to 21)
                    totalvalue = (totalvalue>21) ? 21: totalvalue;
                    
                    //we get overall trust percentage and substract it from 1
                    //the closer the value is to 0, the more trusted users are
                    score = 1- ((float) (totalvalue/21.0));
                    same_group=false;
                   /* if(score>=0.7)
                    {
                       StronglyTrustedGraphs[i][j]=1;
                      // System.out.print(score+" "+crossSectionOfGraphs[i][j]);
                    }
                    else if(score<0.7 && score >0.25)
                    {
                        StronglyTrustedGraphs[i][j]=score;
                    }
                    else
                    {
                       StronglyTrustedGraphs[i][j]=0;
                       //System.out.print(score+" "+crossSectionOfGraphs[i][j]);
                    }*/
                   StronglyTrustedGraphs[i][j]=score;
                
                }
                
            }
        }
        
        //System.out.println("Privacy Value: "+privacyValue+"  Anonymity Value: "+AnonymityValue+"  Authenticity Value: "+AuthenticityValue);
       return StronglyTrustedGraphs; 
    }
    
    
    // A utility function to find the vertex with minimum distance value, 
    // from the set of vertices not yet included in shortest path tree 
    public static int minDistance(double dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        double min = Float.MAX_VALUE;
        int min_index = -1; 
  
        for (int v = 0; v < 100; v++)
        {
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
        }
        return min_index; 
    } 
  
    // A utility function to print the constructed distance array 
    public static void printSolution(double dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < 100; i++) 
            System.out.println(i + " ~~~ " + dist[i]); 
    } 
  
    // Function that implements Dijkstra's single source shortest path 
    // algorithm for a graph represented using adjacency matrix 
    // representation 
    public static void shortest_path_calculation(double graph[][], int src) 
    { 
        double dist[] = new double[100]; // The output array. dist[i] will hold 
        // the shortest distance from src to i 
  
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[100]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < 100; i++) { 
            dist[i] = Float.MAX_VALUE;
            sptSet[i] = false; 
        } 
  
        // Distance of source vertex from itself is always 0 
        dist[src] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < 99; count++) { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet); 
            
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < 100; v++) 
            {
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v] != 0 &&  
                   dist[u] != Float.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
            
            }
        
        } 
  
        // print the constructed distance array 
        printSolution(dist, 100); 
    } 
    
    //compute the authenticity of system by comparing trust and authenticity graphs
    public static void authenticity_calculation(double[][] trust,int[][] authenticity)
    {
        int trust_count=0;
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                //trust value will be between 0 and 1
                //the lower trust value is close to 0, the more trusted users are
                //we maintain a lower threshold value of 0.35.
                //if trust score is less than or equal to 0.35, we consider the users as trusted
                if(trust[i][j]<=0.25)
                {
                    trust[i][j]=1;
                }
                //the lower trust value is close to 1, the more trusted users are
                //we maintain a upper threshold value of 0.65.
                //if trust score is greater than or equal to 0.65, we consider the users as untrusted
                else if(trust[i][j]>=0.60)
                {
                    trust[i][j]=0;
                }
                
                int trust_val=(int) trust[i][j];
                if(trust[i][j]==authenticity[i][j]) trust_count++;
            }
        }
        
        System.out.println("\nBased on privacy and anonymity information, we have come up with a trust graph.\nAfter comparing data in trust and authenticity graphs, we can deduce that the system is = "+(float) trust_count/100+"% authentic.\n");
    }
    
    //for computing the average trust percentage
    //an average user trusts how many users
    public static void trust_percentage_calculation(double[][] trust,int[][] authenticity)
    {
        int trust_count=0;
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                //the lower trust value is close to 0, the more trusted users are
                //we maintain a lower threshold value of 0.35.
                //if trust score is less than or equal to 0.35, we consider the users as trusted
                if(trust[i][j]<=0.25)
                {
                    trust_count++;
                }
            }
        }
        
        int trust_percentage = (trust_count%100)>=50 ? (trust_count/100)+1 : (trust_count/100);
        
        System.out.println("\nThere are 100 users in the system. \nAn average user trusts "+(float) trust_count/100+ " (approximately "+ trust_percentage+ ") users in the system.\n");
    
    }
    
    public static double minKey(double key[], Boolean mstSet[]) 
    { 
        // Initialize min value 
        double min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < 100; v++) 
            if (mstSet[v] == false && key[v] < min) { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    // A utility function to print the constructed MST stored in 
    // parent[] 
    public static void printMST(int parent[], double graph[][]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < 100; i++) 
        {
            if(graph[i][parent[i]]>0)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
        } 
    }
  
    // Function to construct and print MST for a graph represented 
    // using adjacency matrix representation 
    public static void mst_prim(double graph[][]) 
    { 
        // Array to store constructed MST 
        int parent[] = new int[100]; 
  
        // Key values used to pick minimum weight edge in cut 
        double key[] = new double[100]; 
  
        // To represent set of vertices not yet included in MST 
        Boolean mstSet[] = new Boolean[100]; 
  
        // Initialize all keys as INFINITE 
        for (int i = 0; i < 100; i++) { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        // Always include first 1st vertex in MST. 
        key[0] = 0; // Make key 0 so that this vertex is 
        // picked as first vertex 
        parent[0] = -1; // First node is always root of MST 
  
        // The MST will have V vertices 
        for (int count = 0; count < 100 - 1; count++) { 
            // Pick thd minimum key vertex from the set of vertices 
            // not yet included in MST 
            int u = (int)minKey(key, mstSet); 
  
            // Add the picked vertex to the MST Set 
            mstSet[u] = true; 
  
            // Update key value and parent index of the adjacent 
            // vertices of the picked vertex. Consider only those 
            // vertices which are not yet included in MST 
            for (int v = 0; v < 100; v++) 
  
                // graph[u][v] is non zero only for adjacent vertices of m 
                // mstSet[v] is false for vertices not yet included in MST 
                // Update the key only if graph[u][v] is smaller than key[v] 
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) { 
                    parent[v] = u; 
                    key[v] =graph[u][v]; 
                } 
        } 
  
        // print the constructed MST 
        printMST(parent, graph); 
    } 
    public static int show_permission_matrix(int matrix[][],int n)
    {
        
        for (int i=0;i<100;i++)
        {
            for (int j=0;j<100;j++)
            {if (n==1)
                System.out.print(matrix[i][j]+" ");
            else
            System.out.print(matrix[i][j]);
                
            }
            System.out.print("\n");
            
       
        }
        
        return 0;
        }
    public static int link_matrix(int UserGroup[][])
    {
        int i,j;
        for (i=0;i<100;i++)
        {
            for (j=0;j<10;j++)
            {System.out.print(UserGroup[i][j]);
            
            }
            System.out.print("\n");
            
        }
         
        return 0;  
    }
     public static int authenticity_matrix(int Authenticity[][])
     {
         int i,j;
         for (i=0;i<100;i++)
        {
            for (j=0;j<100;j++)
            {System.out.print(Authenticity[i][j]);
            
            }
            System.out.print("\n");
            
        }
        return 0;
     }
     public static void strongly_trusted_component_matrix(double [][]StronglyTrustedComponent,int userID)
     {
         int j,StronglyTrustedUser[][]=new int[100][100];
            for(int itea=0;itea<100;itea++)
            {
                for(int itearation=0;itearation<100;itearation++)
                {
                    if(StronglyTrustedComponent[itea][itearation]>0.6){
                        
                       StronglyTrustedUser[itea][itearation]=1; 
                    }
                    else if(itea==itearation)
                    {
                        StronglyTrustedUser[itea][itearation]=0; 
                    }
                    else
                        StronglyTrustedUser[itea][itearation]=0; 
                        
                }
            }
            GraphStronglyConnectedComponent strong = new GraphStronglyConnectedComponent();
            List<List<Integer>> components = strong.getGraphStronglyConnectedComponent(StronglyTrustedUser);

        System.out.println("Components are : ");

        for (List<Integer> component : components) {
            System.out.println(component);
        }
           /* System.out.println("Strongly Trusted Users of: "+userID+ "         \tScores");
            for (j=0;j<100;j++)
            {
                if(StronglyTrustedComponent[userID][j]<0.3){
                System.out.println(j+"                                \t"+StronglyTrustedComponent[userID][j]);
                }
            }
            
             System.out.println("Semi Trusted Users of"+userID+ "              \tScores");
            for (j=0;j<100;j++)
            {
                if(StronglyTrustedComponent[userID][j]>=0.3&&StronglyTrustedComponent[userID][j]<=0.5){
                System.out.println(j+"                                \t"+StronglyTrustedComponent[userID][j]);
                }
            }
           System.out.println("Untrusted Users of"+userID+ "                   \tScores");
            for (j=0;j<100;j++)
            {
                if(StronglyTrustedComponent[userID][j]>0.5){
                System.out.println(j+"                                \t"+StronglyTrustedComponent[userID][j]);
                }
            } 
        */
     }
     
     
    public static int centralized_zkp_algorithm()
    {
        //describe our approach for verification and giving/blocking access to user information
        System.out.println("In our implementation, a verifier can query data from other user only after verifier is authorized/verified from the system");
        System.out.println("under this PPAI environment. For being authorized, verifier has to provide unique verification code. This code is system-generated and distinct");
        System.out.println("to each user. Applying this verification will help prevent identity fraud. User can't impersonate a different user and access");
        System.out.println("a different user's information. Only after proper verification, verifier can query other user's data. The data shown to verifier");
        System.out.println("will be dependent on queried user's PPAI declaration. If the queried user want to hide data or stay anonimous, verifier will never");
        System.out.println("have access to data. To sum up, Verifier can only access data if he is authorized/verified from the system and he meets PPAI declaration");
        System.out.println("to queried user(verifier must be public, non-anonimous and authentic to queried user)");
        System.out.println();
        System.out.println("You can view the pseudocode for verification and data query steps below:");
        System.out.println();
        System.out.println();
        System.out.println("def ZKP_algorithm(user verifier, user prover):");
        System.out.println("\tbool verified = verification_process(verifier)");
        System.out.println("\t\tif verified==true:");
        System.out.println("\t\t\trequest_prover_information(prover, user, attribute)");
        System.out.println("\t\tif verified == false:");
        System.out.println("\t\t\tprint(\"Sorry! You are not verified.\")");
        System.out.println();
        System.out.println();
        System.out.println("def request_prover_information(user verifier, user prover, attribute_info)");
        System.out.println("\tif authenticity[prover][verifier]==false:");
        System.out.println("\t\tprint(\"Due to authenticity issues, you can't view the data\");");
        System.out.println("\tif authenticity[prover][verifier]==true && privacy[prover][verifier]==true && anonymity[prover][verifier]==true:");
        System.out.println("\t\tprint(\"This data is hidden from you\");");
        System.out.println("\tif authenticity[prover][verifier]==true && privacy[prover][verifier]==false && anonymity[prover][verifier]==false:");
        System.out.println("\t\tprint(\"the attribute of prover is: \"); //data is shown only after verifier is authentic, public and non-anonimous to verifier");
    
        return 0;
    }
        
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Hashmap generated for storing user information
        HashMap<String, User> map = new HashMap<String, User>();
		map = init();
                Set<String> keys = map.keySet();
                for(String key: keys){
       // System.out.println("user: "+key+" attributes: Age: "+ map.get(key).getAge()+ " First Name "+ map.get(key).getFirstName()+" Last Name: "
       //                     +map.get(key).getLastName()+ " Gender: "+ map.get(key).getGender()+" Email: "+ map.get(key).getEmail());
               // System.out.println(map.get(key).getIdentifier());
                
                }       
        int AgePrivacy[][]= new int[100][100];
	int FirstNamePrivacy[][]= new int[100][100];
	int LastNamePrivacy[][]= new int[100][100];
	int GenderPrivacy[][]= new int[100][100];
	int SnsPrivacy[][]= new int[100][100];
        int PrimaryLanguagePrivacy[][]= new int[100][100];
        int EmailPrivacy[][]= new int[100][100];
        
        
        int AgeAnonymity[][]= new int[100][100];
	int IdentityAnonymity[][]= new int[100][100];
	int GenderAnonymity[][]= new int[100][100];
        int PrimaryLanguageAnonymity[][]= new int[100][100];
        int EmailAnonymity[][]= new int[100][100];
        
        int Authenticity[][] = new int[100][100];
        float trust[][] = new float[100][100];
        
        int UserGroup[][]= new int [100][10];
        
        
        int Group2GroupPrivacy[][]= new int[10][10];
        int Group2GroupAnonymity[][]= new int[10][10];
        int Group2GroupAuthenticity[][]= new int[10][10];
        
        String Verification_code_list[] = new String[100];
        File file = new File("Verification_code.txt"); 
  
        int count=0;
        BufferedReader br = new BufferedReader(new FileReader(file)); 

        String st; 
        while ((st = br.readLine()) != null && count<100){ 
           Verification_code_list[count++]=st;
        }
        
        
        //Creating privacy graphs
        CreateGraph(AgePrivacy,"AgePrivacy",100,100);
        CreateGraph(FirstNamePrivacy,"FirstnamePrivacy",100,100);
	CreateGraph(LastNamePrivacy,"Gender",100,100);
	CreateGraph(GenderPrivacy,"LastNamePrivacy",100,100);
        CreateGraph(SnsPrivacy,"SnsPrivacy",100,100);
        CreateGraph(PrimaryLanguagePrivacy,"PrimaryLanguagePrivacy",100,100);
        CreateGraph(EmailPrivacy,"EmailPrivacy",100,100);
        
        
        //Creating anonymity graphs
	CreateGraph(AgeAnonymity,"AgeAnonymity",100,100);
        CreateGraph(IdentityAnonymity,"IdentityAnonymity",100,100);
        CreateGraph(GenderAnonymity,"GenderAnonymity",100,100);
        CreateGraph(PrimaryLanguageAnonymity,"PrimaryLanguageAnonymity",100,100);
        CreateGraph(EmailAnonymity,"EmailAnonymity",100,100);
        
        CreateAuthenticGraph(Authenticity,"Authenticity",100,100);
        
        //Creating group to group graphs
        CreateGroupGraph(Group2GroupPrivacy,"Group2GroupPrivacy",10,10);
        CreateGroupGraph(Group2GroupAnonymity,"Group2GroupAnonymity",10,10);
        CreateAuthenticGroupGraph(Group2GroupAuthenticity,"Group2GroupAuthenticity",10,10);
        
        
        //Creating user to group graph
        CreateGraph(UserGroup,"UserGroup",100,10);
        
        int[][] UserGroupGraph = PrepareGroupWiseUserList(UserGroup); //Create a list of groupwise users
        
        //overriding data in privacy and anonymity graphs among users of same group. making it public(for privacy graph) 
        //or unanimous(for anonymity graph)
        
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<99;j++)
            {
                if(UserGroupGraph[i][j]!=-1)
                {
                    for(int k=j+1;k<100;k++)
                    {
                        if(UserGroupGraph[i][k]!=-1 && UserGroupGraph[i][j]!=UserGroupGraph[i][k])
                        {
                            AgePrivacy[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            AgePrivacy[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            AgeAnonymity[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            AgeAnonymity[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            
                            GenderPrivacy[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            GenderPrivacy[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            GenderAnonymity[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            GenderAnonymity[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            
                            PrimaryLanguagePrivacy[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            PrimaryLanguagePrivacy[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            PrimaryLanguageAnonymity[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            PrimaryLanguageAnonymity[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            
                            EmailPrivacy[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            EmailPrivacy[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            EmailAnonymity[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            EmailAnonymity[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            
                            FirstNamePrivacy[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            FirstNamePrivacy[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            LastNamePrivacy[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            LastNamePrivacy[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            SnsPrivacy[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            SnsPrivacy[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            IdentityAnonymity[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=0;
                            IdentityAnonymity[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=0;
                            
                            Authenticity[UserGroupGraph[i][j]][UserGroupGraph[i][k]]=1;
                            Authenticity[UserGroupGraph[i][k]][UserGroupGraph[i][j]]=1;
                        }
                    }
                }
            }
        }
        
        //override data based on group to group privacy and anonymity information
        for(int i=0;i<10;i++)
        {
                for(int j=0;j<10;j++)
                {
                    
                    
                    if(Group2GroupPrivacy[i][j]==1) 
                    {
                        int[][] UserListForGraphOverriding = new int[2][];
                        
                        //prepare userlist for 2 groups for which there are privacy/anonymity relation
                        UserListForGraphOverriding = PrepareUserListForGraphOverriding(i,j,UserGroupGraph); 
                        
                        //override single attribute graphs depending on userlist data
                        AgePrivacy = DataOverrideAttributeGraph(UserListForGraphOverriding, AgePrivacy,1);
                        FirstNamePrivacy = DataOverrideAttributeGraph(UserListForGraphOverriding, FirstNamePrivacy,1);
                        LastNamePrivacy = DataOverrideAttributeGraph(UserListForGraphOverriding, LastNamePrivacy,1);
                        GenderPrivacy = DataOverrideAttributeGraph(UserListForGraphOverriding, GenderPrivacy,1);
                        SnsPrivacy = DataOverrideAttributeGraph(UserListForGraphOverriding, SnsPrivacy,1);
                        PrimaryLanguagePrivacy = DataOverrideAttributeGraph(UserListForGraphOverriding, PrimaryLanguagePrivacy,1);
                        EmailPrivacy = DataOverrideAttributeGraph(UserListForGraphOverriding, EmailPrivacy,1);
                        
                    }
                    
                    if(Group2GroupAnonymity[i][j]==1) 
                    {
                        int[][] UserListForGraphOverriding = new int[2][];
                        
                        //prepare userlist for 2 groups for which there are privacy/anonymity relation
                        UserListForGraphOverriding = PrepareUserListForGraphOverriding(i,j,UserGroupGraph); 
                        
                        //override single attribute graphs depending on userlist data
                        AgeAnonymity = DataOverrideAttributeGraph(UserListForGraphOverriding, AgeAnonymity,1);
                        IdentityAnonymity = DataOverrideAttributeGraph(UserListForGraphOverriding, IdentityAnonymity,1);
                        GenderAnonymity = DataOverrideAttributeGraph(UserListForGraphOverriding, GenderAnonymity,1);
                        PrimaryLanguageAnonymity = DataOverrideAttributeGraph(UserListForGraphOverriding, PrimaryLanguageAnonymity,1);
                        EmailAnonymity = DataOverrideAttributeGraph(UserListForGraphOverriding, EmailAnonymity,1);
                    }
                    
                    if(Group2GroupAuthenticity[i][j]==0) 
                    {
                        int[][] UserListForGraphOverriding = new int[2][];
                        
                        //prepare userlist for 2 groups for which there are privacy/anonymity relation
                        UserListForGraphOverriding = PrepareUserListForGraphOverriding(i,j,UserGroupGraph); 
                        
                        //override single attribute graphs depending on userlist data
                        Authenticity = DataOverrideAttributeGraph(UserListForGraphOverriding, Authenticity,0);
                        
                    }
                }
        }
        
        
        //overriding data in 2 phases
        //1.    if two users' privacy information is public and anonymity information is non-anonymous,
        //  we will change anonymity information to anonymous
        //2,    if two users' anonymity information in non-identity information bearing graphs are anonymous and 
        // identity information bearing graphs are non-anonymous, we override the data in identity information bearing graphs
        //  and make it anonymous
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(AgePrivacy[i][j]==1 && AgeAnonymity[i][j]==0)
                {
                    AgeAnonymity[i][j]=1;
                }
                
                if(GenderPrivacy[i][j]==1 && GenderAnonymity[i][j]==0)
                {
                    GenderAnonymity[i][j]=1;
                }
                
                if(PrimaryLanguagePrivacy[i][j]==1 && PrimaryLanguageAnonymity[i][j]==0)
                {
                    PrimaryLanguageAnonymity[i][j]=1;
                }
                
                if(EmailPrivacy[i][j]==1 && EmailAnonymity[i][j]==0)
                {
                    EmailAnonymity[i][j]=1;
                }
                
                if(FirstNamePrivacy[i][j]==1 && IdentityAnonymity[i][j]==0)
                {
                    IdentityAnonymity[i][j]=1;
                }
                
                if(LastNamePrivacy[i][j]==1 && IdentityAnonymity[i][j]==0)
                {
                    IdentityAnonymity[i][j]=1;
                }
                
                if(SnsPrivacy[i][j]==1 && IdentityAnonymity[i][j]==0)
                {
                    IdentityAnonymity[i][j]=1;
                }
                
                if(AgeAnonymity[i][j]==1 && IdentityAnonymity[i][j]==0)
                {
                    IdentityAnonymity[i][j]=1;
                }
                else if(GenderAnonymity[i][j]==1 && IdentityAnonymity[i][j]==0)
                {
                    IdentityAnonymity[i][j]=1;
                }
                else if(PrimaryLanguageAnonymity[i][j]==1 && IdentityAnonymity[i][j]==0)
                {
                    IdentityAnonymity[i][j]=1;
                }
                else if(EmailAnonymity[i][j]==1 && IdentityAnonymity[i][j]==0)
                {
                    IdentityAnonymity[i][j]=1;
                }
            }
        }
        
        
       
        //overriding data in privacy and anonymity graphs based on data in authenticity graphs
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                if(Authenticity[i][j]==0 && AgePrivacy[i][j]==0)
                {
                    AgePrivacy[i][j]=0;
                }
                
                else if(Authenticity[i][j]==0 && AgePrivacy[i][j]==1)
                {
                    AgePrivacy[i][j]=1;
                }
                
                else if(Authenticity[i][j]==1 && AgePrivacy[i][j]==0)
                {
                    AgePrivacy[i][j]=10;
                }
                
                else if(Authenticity[i][j]==1 && AgePrivacy[i][j]==1)
                {
                    AgePrivacy[i][j]=11;
                }
                
                
                if(Authenticity[i][j]==0 && GenderPrivacy[i][j]==0)
                {
                    GenderPrivacy[i][j]=0;
                }
                
                else if(Authenticity[i][j]==0 && GenderPrivacy[i][j]==1)
                {
                    GenderPrivacy[i][j]=1;
                }
                
                else if(Authenticity[i][j]==1 && GenderPrivacy[i][j]==0)
                {
                    GenderPrivacy[i][j]=10;
                }
                
                else if(Authenticity[i][j]==1 && GenderPrivacy[i][j]==1)
                {
                    GenderPrivacy[i][j]=11;
                }
                
                
                if(Authenticity[i][j]==0 && PrimaryLanguagePrivacy[i][j]==0)
                {
                    PrimaryLanguagePrivacy[i][j]=0;
                }
                
                else if(Authenticity[i][j]==0 && PrimaryLanguagePrivacy[i][j]==1)
                {
                    PrimaryLanguagePrivacy[i][j]=1;
                }
                
                else if(Authenticity[i][j]==1 && PrimaryLanguagePrivacy[i][j]==0)
                {
                    PrimaryLanguagePrivacy[i][j]=10;
                }
                
                else if(Authenticity[i][j]==1 && PrimaryLanguagePrivacy[i][j]==1)
                {
                    PrimaryLanguagePrivacy[i][j]=11;
                }
                
                
                if(Authenticity[i][j]==0 && EmailPrivacy[i][j]==0)
                {
                    EmailPrivacy[i][j]=0;
                }
                
                else if(Authenticity[i][j]==0 && EmailPrivacy[i][j]==1)
                {
                    EmailPrivacy[i][j]=1;
                }
                
                else if(Authenticity[i][j]==1 && EmailPrivacy[i][j]==0)
                {
                    EmailPrivacy[i][j]=10;
                }
                
                else if(Authenticity[i][j]==1 && EmailPrivacy[i][j]==1)
                {
                    EmailPrivacy[i][j]=11;
                }
                
                
                if(Authenticity[i][j]==0 && FirstNamePrivacy[i][j]==0)
                {
                    FirstNamePrivacy[i][j]=0;
                }
                
                else if(Authenticity[i][j]==0 && FirstNamePrivacy[i][j]==1)
                {
                    FirstNamePrivacy[i][j]=1;
                }
                
                else if(Authenticity[i][j]==1 && FirstNamePrivacy[i][j]==0)
                {
                    FirstNamePrivacy[i][j]=10;
                }
                
                else if(Authenticity[i][j]==1 && FirstNamePrivacy[i][j]==1)
                {
                    FirstNamePrivacy[i][j]=11;
                }
                
                
                if(Authenticity[i][j]==0 && LastNamePrivacy[i][j]==0)
                {
                    LastNamePrivacy[i][j]=0;
                }
                
                else if(Authenticity[i][j]==0 && LastNamePrivacy[i][j]==1)
                {
                    LastNamePrivacy[i][j]=1;
                }
                
                else if(Authenticity[i][j]==1 && LastNamePrivacy[i][j]==0)
                {
                    LastNamePrivacy[i][j]=10;
                }
                
                else if(Authenticity[i][j]==1 && LastNamePrivacy[i][j]==1)
                {
                    LastNamePrivacy[i][j]=11;
                }
                
                
                if(Authenticity[i][j]==0 && SnsPrivacy[i][j]==0)
                {
                    SnsPrivacy[i][j]=0;
                }
                
                else if(Authenticity[i][j]==0 && SnsPrivacy[i][j]==1)
                {
                    SnsPrivacy[i][j]=1;
                }
                
                else if(Authenticity[i][j]==1 && SnsPrivacy[i][j]==0)
                {
                    SnsPrivacy[i][j]=10;
                }
                
                else if(Authenticity[i][j]==1 && SnsPrivacy[i][j]==1)
                {
                    SnsPrivacy[i][j]=11;
                }
                
                
            }
        }
        
        //rewrite privacy graphs
        WriteGraphToTextFile(AgePrivacy,"AgePrivacy",100,100);
        WriteGraphToTextFile(FirstNamePrivacy,"FirstnamePrivacy",100,100);
	WriteGraphToTextFile(LastNamePrivacy,"Gender",100,100);
	WriteGraphToTextFile(GenderPrivacy,"LastNamePrivacy",100,100);
        WriteGraphToTextFile(SnsPrivacy,"SnsPrivacy",100,100);
        WriteGraphToTextFile(PrimaryLanguagePrivacy,"PrimaryLanguagePrivacy",100,100);
        WriteGraphToTextFile(EmailPrivacy,"EmailPrivacy",100,100);
        
        
        //rewrite anonymity graphs
	WriteGraphToTextFile(AgeAnonymity,"AgeAnonymity",100,100);
        WriteGraphToTextFile(IdentityAnonymity,"IdentityAnonymity",100,100);
        WriteGraphToTextFile(GenderAnonymity,"GenderAnonymity",100,100);
        WriteGraphToTextFile(PrimaryLanguageAnonymity,"PrimaryLanguageAnonymity",100,100);
        WriteGraphToTextFile(EmailAnonymity,"EmailAnonymity",100,100);
        
        //rewrite authenticity graphs
        WriteGraphToTextFile(Authenticity,"Authenticity",100,100);
        
        
        int CrossSectionOfGraphs[][][]= new int[14][100][100];
        
        CrossSectionOfGraphs[0]=FirstNamePrivacy;
        CrossSectionOfGraphs[1]=LastNamePrivacy;
        CrossSectionOfGraphs[2]=SnsPrivacy;
        CrossSectionOfGraphs[3]=AgePrivacy;
        
        CrossSectionOfGraphs[4]=GenderPrivacy;
        CrossSectionOfGraphs[5]=EmailPrivacy;
        CrossSectionOfGraphs[6]=PrimaryLanguagePrivacy;
        CrossSectionOfGraphs[7]=EmailAnonymity;
        CrossSectionOfGraphs[8]=IdentityAnonymity;
        CrossSectionOfGraphs[9]=PrimaryLanguageAnonymity;
        CrossSectionOfGraphs[10]=GenderAnonymity;
        CrossSectionOfGraphs[11]=AgeAnonymity;
        CrossSectionOfGraphs[12]=Authenticity;
        CrossSectionOfGraphs[13]=UserGroup;
        
        double [][] StronglyTrustedComponent=getStronglyTrusted(CrossSectionOfGraphs);
        
        
        //GetMostTrustedUsersList(0,StronglyTrustedComponent);
        
        //shortest_path_calculation(StronglyTrustedComponent, 0);
        
        //trust_percentage_calculation(StronglyTrustedComponent,Authenticity);
        
        //authenticity_calculation(StronglyTrustedComponent,Authenticity);
        
        //mst_prim(StronglyTrustedComponent);
        //hamim        
        Scanner myObj = new Scanner(System.in);
        String input_verification_code="", input_verification_code_1="";
        System.out.println("*******************************Welcome to Identity Management System********************************");
        System.out.println("Please wait...........");
        Thread.sleep(3000);
        System.out.println();
        System.out.println("This Project has been done by:");
        System.out.println();
        System.out.println("Farhan Tanvir      Muhammad Ifte Khairul Islam       Khaled Mohammed Saifuddin ");
        System.out.println("A20210895          A20224247                         A20232538 ");
        Thread.sleep(3000);
        System.out.print('\f');
        System.out.println("Let's Proceed................");
        System.out.println();       
        System.out.println("Enter your ID (Choose any number between 0 and 99):");
        String ID = myObj.nextLine();
        int active_user_id = Integer.parseInt(ID);
        System.out.println("Your ID is: " + ID);
        int id = Integer.parseInt(ID);//convering string type ID to integer id, because later this will help to indexing 2-D array
        String original_verification_code=map.get(ID).getIdentifier();
        String original_verification_code_1=map.get(ID).getIdentifier();
        boolean a;
        boolean verified_user=false;
        a = map.containsKey(ID);
        if (a==true)
        {
           System.out.println("Welcome To Our System\n");
           System.out.println("Do You Want To Proceed?Y/N \n");
           String agreement = myObj.nextLine();
           if (agreement.equalsIgnoreCase("Y")) {
               
               System.out.println("Nice! You are Proceeding To The Next Steps");
               
               while(true)
               {  System.out.println("To see menu enter any key");
                  String key = myObj.nextLine();
                  if(key.length()!=0){    
                  System.out.println("Press: 1  -To explore Specific Attribute of a Specific User.          |                   Press: 7   -To see Permission Matrix.");
                  System.out.println("Press: 2  -To explore Specific Attribute of All Users.                |                   Press: 8   -To see Link Matix.");
                  System.out.println("Press: 3  -To explore BFS.                                            |                   Press: 9   -To discover Cross-section between graphs.");
                  System.out.println("Press: 4  -To explore DFS.                                            |                   Press: 10  -To see Autheticity Matrix.");
                  System.out.println("press: 5  -To see trusted list.                                       |                   Press: 11  -To see Strongly Trusted Component.");
                  System.out.println("Press: 6  -To see untrusted list.                                     |                   Press: 12  -To see Shortest Path.");
                  System.out.println("Press: 13 -To see Minimum Trusted Spanning Tree                       |                   Press: 14  -To see Trustfulness of users.");
                  System.out.println("Press: 15 -To see authenticity of the system.                         |                   Press: 16  -To see ZKP algorithm.");               
                  System.out.println("Press: 17 -To Exit ");
                  }       
                  String expression = myObj.nextLine();
                  switch(expression) {
    case "1":
        //user has to provide verification code if he isn't verified yet
        if(!verified_user)
        {
            System.out.println("Please provide your system-generated unique verification code: ( You can find the verification code from Verification_code.txt file.\n In the txt file users verfication code stores serially. For example: user 0's verification code is in line '0'\n 0's is in line 'o'\n and so on...");
             input_verification_code = myObj.nextLine();
        }
        //if user provides correct verification code or he is already verified, he will procceed to next step
        if(Verification_code_list[id].equals(input_verification_code) || verified_user)
        {
            System.out.print("You are a verified user.\n");
            verified_user=true;
            System.out.println("For Specific User Give User ID (Choose any number between 0 and 99):");
            String user_id = myObj.nextLine();
            if (map.containsKey(user_id))
            {
                System.out.println("To see First Name:1\n To see Last Name:2\n To see Age:3 \n To see Gender:4\n To see Email:5\n To see SNS:6\n");
                int user_id1=Integer.parseInt(user_id);
                String user_attribute = myObj.nextLine();
                switch (user_attribute)
                {    
                    case "1":
                        case1_1(FirstNamePrivacy, IdentityAnonymity, Authenticity, user_id, id,user_id1, map);
                        break;
                    case "2": 
                        case1_2(LastNamePrivacy, IdentityAnonymity,Authenticity,user_id, id,user_id1, map);
                        break;
                    case "3":
                        case1_3(AgePrivacy, AgeAnonymity,Authenticity,user_id, id,user_id1, map);
                        break;
                    case "4":
                        case1_4(GenderPrivacy, GenderAnonymity, Authenticity,user_id,id, user_id1, map);
                        break;
                    case "5":
                        case1_5(EmailPrivacy, EmailAnonymity, Authenticity,user_id,id, user_id1, map);
                        break;
                    case "6":
                        case1_6(SnsPrivacy, IdentityAnonymity, Authenticity,user_id,id, user_id1, map);
                        break;
                    default:
                        break;
                }
            }
            else 
            {
                System.out.println("Invalid User ID");
            }
        }
        else 
        {
            System.out.println("Sorry! You have provided invalid verification code.");
        }
        break;
        
    case "2":
        //user has to provide verification code if he isn't verified yet
        if(!verified_user)
        {
            System.out.println("Please provide your system-generated unique verification code: ( You can find the verification code from Verification_code.txt file.\n In the txt file users verfication code stores serially. For example: user 0's verification code is in line '0'\n 1's is in line '1'\n and so on...");
            input_verification_code_1 = myObj.nextLine();
        }
        //if user provides correct verification code or he is already verified, he will procceed to next step
        if(Verification_code_list[id].equals(input_verification_code_1) || verified_user)
        {
            System.out.print("You are a verified user.\n");
            verified_user=true;
            System.out.println("To see First Name:1\n To see Last Name:2\n To see Age:3 \n To see Gender:4\n To see Email:5\n To see SNS:6 ");
            String user_attribute1 = myObj.nextLine();
            switch (user_attribute1)
            {
                case "1":
                 case2_1(FirstNamePrivacy, IdentityAnonymity, Authenticity,id, map);
                 break;
                case "2":
                 case2_2(LastNamePrivacy, IdentityAnonymity,  Authenticity,id, map);   
                 break;
                case "3":
                 case2_3(AgePrivacy, AgeAnonymity,  Authenticity,id, map);
                 break;
                case "4":
                 case2_4(GenderPrivacy, GenderAnonymity, Authenticity,id, map);
                 break;
                case "5": 
                 case2_5(EmailPrivacy, EmailAnonymity,  Authenticity,id, map);
                 break;
                case "6": 
                 case2_6(SnsPrivacy, IdentityAnonymity, Authenticity,id, map);
                 break;
                 default:
                 break; 
            }
        }
        else 
        {
            System.out.println("Sorry! You have provided invalid verification code.");
        }
        break;
    case "3":
        System.out.println("Which type of graph do you want to traverse?\nTo choose privacy:   Press 1\nTo choose Anonymity: Press 2");
        String user_attribute4 = myObj.nextLine();
              switch (user_attribute4)
                {
                  case "1":
                  {
                      System.out.println("Which privacy graph do you want to select?\n To choose First Name: Press 1\n To choose Last Name: Press 2\n To choose Age: Press 3\n To choose Gender: Press 4\n To choose Email: press 5\n To choose SSN: Press 6\n To choose Primary Language: Press 7");
                      String user_attribute5 = myObj.nextLine();
                      switch (user_attribute5)
                      {
                          case "1":
                              breadthFirstSearch(FirstNamePrivacy, id);
                              break;
                          case "2":
                               breadthFirstSearch(LastNamePrivacy, id);   
                               break;
                          case "3": 
                               breadthFirstSearch(AgePrivacy, id);
                               break;
                          case "4": 
                               breadthFirstSearch(GenderPrivacy, id);
                               break;
                          case "5": 
                               breadthFirstSearch(EmailPrivacy, id);
                               break;
                         case "6": 
                                breadthFirstSearch(SnsPrivacy, id);
                                break;
                         case "7": 
                                breadthFirstSearch(PrimaryLanguagePrivacy, id);
                                break;
                         default: 
                                break;
                        
                      }
                  
                  }
                  break;
            case "2":
                System.out.println("Which anonymity graph do you want to select?\n To choose Identity Matrix: Press 1\n  To choose Age: Press 2\n To choose Gender: Press 3\n To choose Email: press 4\n  To choose Primary Language: Press 5");
                      String user_attribute6 = myObj.nextLine();
                      switch (user_attribute6)
                      {
                          case "1":
                              breadthFirstSearch(IdentityAnonymity, id);
                              break;
                          case "2": 
                               breadthFirstSearch(AgeAnonymity, id);
                               break;
                          case "3": 
                               breadthFirstSearch(GenderAnonymity, id);
                               break;
                          case "4": 
                               breadthFirstSearch(EmailAnonymity, id);
                          case "5":
                               breadthFirstSearch(PrimaryLanguageAnonymity,id);
                               break;
                         default: 
                                break;
                        
                      }
                break;
                }
        break;
    case "4":
        System.out.println("Which type of graph do you want to traverse?\nTo choose privacy:   Press 1\nTo choose Anonymity: Press 2");
        String user_attribute7 = myObj.nextLine();
                     switch (user_attribute7)
                {
                  case "1":
                  {
                      System.out.println("Which privacy graph do you want to select?\n To choose First Name: Press 1\n To choose Last Name: Press 2\n To choose Age: Press 3\n To choose Gender: Press 4\n To choose Email: press 5\n To choose SSN: Press 6\n To choose Primary Language: Press 7");
                      String user_attribute8 = myObj.nextLine();
                      switch (user_attribute8)
                      {
                          case "1":
                              depthFirstSearch(FirstNamePrivacy, id);
                              break;
                          case "2":
                               depthFirstSearch(LastNamePrivacy, id);   
                               break;
                          case "3": 
                               depthFirstSearch(AgePrivacy, id);
                               break;
                          case "4": 
                               depthFirstSearch(GenderPrivacy, id);
                               break;
                          case "5": 
                               depthFirstSearch(EmailPrivacy, id);
                               break;
                         case "6": 
                                depthFirstSearch(SnsPrivacy, id);
                                break;
                         case "7": 
                                depthFirstSearch(PrimaryLanguagePrivacy, id);
                                break;
                         default: 
                                break;
                        
                      }
                  
                  }
                  break;
            case "2":
                System.out.println("Which anonymity graph do you want to select?\n To choose Identity Matrix: Press 1\n  To choose Age: Press 2\n To choose Gender: Press 3\n To choose Email: press 4\n  To choose Primary Language: Press 5");
                      String user_attribute9 = myObj.nextLine();
                      switch (user_attribute9)
                      {
                          case "1":
                              depthFirstSearch(IdentityAnonymity, id);
                              break;
                          case "2": 
                               depthFirstSearch(AgeAnonymity, id);
                               break;
                          case "3": 
                               depthFirstSearch(GenderAnonymity, id);
                               break;
                          case "4": 
                               depthFirstSearch(EmailAnonymity, id);
                          case "5":
                               depthFirstSearch(PrimaryLanguageAnonymity,id);
                               break;
                         default: 
                                break;
                        
                      }
                break;
                }    
    break;                
    case "5":
        System.out.println("For which attribute, do you want to see trusted list?\n To see First Name: Press 1\n To see Last Name: Press 2\n To see Age: Press 3 \n To see Gender: Press 4\n To see Email: Press 5\n To see SNS: Press 6 ");
        String user_attribute2 = myObj.nextLine();
              switch (user_attribute2)
         {
            case "1":
             GetTrustedUsersList(active_user_id, FirstNamePrivacy, IdentityAnonymity, map);
             break;
            case "2":
             GetTrustedUsersList(active_user_id, LastNamePrivacy, IdentityAnonymity, map);   
             break;
            case "3":
             GetTrustedUsersList(active_user_id, AgePrivacy, AgeAnonymity, map);
             break;
            case "4":
             GetTrustedUsersList(active_user_id, GenderPrivacy, GenderAnonymity,map);
             break;
            case "5": 
             GetTrustedUsersList(active_user_id, EmailPrivacy, EmailAnonymity,map);
             break;
            case "6": 
             GetTrustedUsersList(active_user_id, SnsPrivacy, IdentityAnonymity, map);
             break;
                      default:
                      break; 
        }
        break;
    case "6":
        System.out.println("For which attribute, do you want to see untrusted list?\n To see First Name: Press 1\n To see Last Name: Press 2\n To see Age: Press 3 \n To see Gender: Press 4\n To see Email: Press 5\n To see SNS: Press 6 ");
        String user_attribute3 = myObj.nextLine();
              switch (user_attribute3)
         {
            case "1":
             GetUntrustedUsersList(active_user_id, FirstNamePrivacy, IdentityAnonymity, map);
             break;
            case "2":
             GetUntrustedUsersList(active_user_id, LastNamePrivacy, IdentityAnonymity, map);   
             break;
            case "3":
             GetUntrustedUsersList(active_user_id, AgePrivacy, AgeAnonymity, map);
             break;
            case "4":
             GetUntrustedUsersList(active_user_id, GenderPrivacy, GenderAnonymity,map);
             break;
            case "5": 
             GetUntrustedUsersList(active_user_id, EmailPrivacy, EmailAnonymity,map);
             break;
            case "6": 
             GetUntrustedUsersList(active_user_id, SnsPrivacy, IdentityAnonymity, map);
             break;
                      default:
                      break; 
        }
        break;       
    case "7":
        System.out.println("Which type of permission matrix do you want to see? \n 1.Privacy\n 2.Anonymity\n");
        String user_attribute8 = myObj.nextLine();
        switch(user_attribute8)
        {
            case "1":
                System.out.println("Which privacy matrix do you want to see? \n 1.First Name\n 2.Last Name\n 3.Age\n 4.Gender\n 5.Email \n 6.SSN\n 7.Language");
                String user_attribute9 = myObj.nextLine();
                switch(user_attribute9)
                {
                    case "1":
                        show_permission_matrix(FirstNamePrivacy,1);
                        break;
                    case "2":
                        show_permission_matrix(LastNamePrivacy,1);
                        break;
                    case "3":
                        show_permission_matrix(AgePrivacy,1);
                        break;
                    case "4":
                        show_permission_matrix(GenderPrivacy,1);
                        break;
                    case "5":
                        show_permission_matrix(EmailPrivacy,1);
                        break;
                    case "6":
                        show_permission_matrix(SnsPrivacy,1);
                        break;
                    case "7":
                        show_permission_matrix(PrimaryLanguagePrivacy,1);
                        break;
                    
                    default: 
                        break;
                        
                }
                break;
        
            case "2":
                System.out.println("Which Anonymity matrix do you want to see? \n 1.Identity\n 2.Age\n 3.Gender\n 4.Email \n 5.Language");
                String user_attribute10 = myObj.nextLine();
                switch(user_attribute10)
                {
                    case "1":
                        show_permission_matrix(IdentityAnonymity,0);
                        break;
                    case "2":
                        show_permission_matrix(AgeAnonymity,0);
                        break;
                    case "3":
                        show_permission_matrix(GenderAnonymity,0);
                        break;
                    case "4":
                        show_permission_matrix(EmailAnonymity,0);
                        break;
                    case "5":
                        show_permission_matrix(PrimaryLanguageAnonymity,0);
                        break;
                    default: 
                        break;       
                }
                break; 
                default:
                    break;
        }
        break;
        
    case "8":
        System.out.println("Link Matrix: User-Group:\n");
        link_matrix(UserGroup);
        break;
    case "9":
        System.out.print("Enter the Number of Graphs: ");
        String num = myObj.nextLine();
        int num_of_graphs = Integer.parseInt(num);//convering string type ID to integer id, because later this will help to indexing 2-D array   
        System.out.println("Select Graph:\n"+
                      "1: AgePrivacy \n"+
                      "2: FirstNamePrivacy\n" +
                      "3: LastNamePrivacy\n" +
                      "4: GenderPrivacy\n" +
                      "5: SnsPrivacy\n" +
                      "6: PrimaryLanguagePrivacy\n" +
                      "7: EmailPrivacy\n" +
                      "8: IdentityAnonymity\n" +
                      "9: PrimaryLanguageAnonymity\n" +
                      "10: GenderAnonymity\n" +
                      "11: SnsAnonymity\n" +
                      "12: EmailAnonymity\n"+
		      "13: Authenticity\n" );    
        for(int itea=0; itea<num_of_graphs; itea++)
        {
        String GraphNumber = myObj.nextLine();
        int GraphNumber1 = Integer.parseInt(GraphNumber);//convering string type ID to integer id, because later this will help to indexing 2-D array
            switch(GraphNumber1)
            {
                case 1:
                    CrossSectionOfGraphs[itea]=AgePrivacy;
                    break;
                case 2:
                    CrossSectionOfGraphs[itea]=FirstNamePrivacy;
                    break;
                case 3:
                    CrossSectionOfGraphs[itea]=LastNamePrivacy;
                    break;
                case 4:
                    CrossSectionOfGraphs[itea]=GenderPrivacy;
                    break;
                case 5:
                    CrossSectionOfGraphs[itea]=SnsPrivacy;
                    break;
                case 6:
                    CrossSectionOfGraphs[itea]=PrimaryLanguagePrivacy;
                    break;
                case 7:
                    CrossSectionOfGraphs[itea]=EmailPrivacy;
                    break;
                case 8:
                    CrossSectionOfGraphs[itea]=IdentityAnonymity;
                    break;
                case 9:
                    CrossSectionOfGraphs[itea]=PrimaryLanguageAnonymity;
                    break;
                case 10:
                    CrossSectionOfGraphs[itea]=GenderAnonymity;
                    break;
                case 11:
                    CrossSectionOfGraphs[itea]=AgeAnonymity;
                    break;
                case 12:
                    CrossSectionOfGraphs[itea]=EmailAnonymity;
                    break;
		case 13:
		    CrossSectionOfGraphs[itea]=Authenticity;
                    break;
                default:
                    System.out.println("Please select a number between 1 to 12");
                    itea--;
                    break;   
            }
        }
                int [][]cross_sec=getCrossSectionGraphs(CrossSectionOfGraphs,num_of_graphs);
        for (int i=0;i<100;i++)
        {
            for (int j=0;j<100;j++)
            {
                System.out.print(cross_sec[i][j]);
            }
                System.out.print("\n");
            
        }
        System.out.println("Select algorithm to traverse this cross-sectional graph\n 1.BFS\n 2.DFS");
        String str = myObj.nextLine();
        String str1="1";
        String str2="2";
        
        if (str.equals(str1))
        {
           breadthFirstSearch(cross_sec, id);
           break;
                               
        }
        if (str.equals(str2))
        {
            depthFirstSearch(cross_sec,id);
            break;
        }
                 
break;
    case "10":
        System.out.print("Authenticity Matrix:\n");
        authenticity_matrix(Authenticity);
        break;
    case "11":
        strongly_trusted_component_matrix(StronglyTrustedComponent, id);
        break;
    case "12":
        System.out.print("Shortest Trust Path Calculation:\n");
        shortest_path_calculation(StronglyTrustedComponent, id);
        break;
    case "13":
       System.out.print("Minimum Trusted Spanning Tree:\n");       
        mst_prim(StronglyTrustedComponent);
        break;
    case "14":
        trust_percentage_calculation(StronglyTrustedComponent,Authenticity);
        break;       
    case "15":
        authenticity_calculation(StronglyTrustedComponent,Authenticity);
        break; 
    case "16":
        centralized_zkp_algorithm();
        break;
    case "17":
        System.exit(0);
        break;
        default:
        break;
                  }
               }
            } 
           else System.exit(0);
        }
               
    }  
 }
    
 
class GraphStronglyConnectedComponent {

    public static List<List<Integer>> getGraphStronglyConnectedComponent(int[][] graph) {
        boolean[] visitedVertices = new boolean[graph.length];

        /** To put vertices in finish time by decreasing order **/
        Stack<Integer> stack = new Stack<>();

        /** DFS and put data in stack **/
        for (int vertex = 0; vertex < graph.length; vertex++) {
            if (!visitedVertices[vertex]) {
                DFSForGraph(graph, visitedVertices, stack, vertex);
            }
        }

        /** Create reverse stack **/
        int[][] reverseGraph = getReverseGraph(graph);

        /** List of all strongly connected component **/
        List<List<Integer>> components = new ArrayList<>();

        /** New array for visited vertices in reverse stack **/
        visitedVertices = new boolean[graph.length];

        /** Process till stack is not empty **/
        while (!stack.isEmpty()) {
            /** Pop element from stack **/
            int vertex = stack.pop();
            /** if its not visited and call DFS on reverse graph **/
            if (!visitedVertices[vertex]) {
                List<Integer> component = new ArrayList<>();
                DFSForReverseGraph(reverseGraph, visitedVertices, component, vertex);

                components.add(component);
            }
        }

        return components;
    }

    private static void DFSForGraph(int[][] graph, boolean[] visitedVertices, Stack<Integer> stack, int vertex) {
        /** Mark vertex as visited **/
        visitedVertices[vertex] = true;

        /** Iterate over all adjacent vertices  **/
        for (Integer adjacentVertex : getAdjacentVertices(graph, vertex)) {
            if (!visitedVertices[adjacentVertex]) {
                DFSForGraph(graph, visitedVertices, stack, adjacentVertex);
            }
        }

        /** When all adjacent vertices process then add vertex to stack **/
        stack.push(vertex);
    }

    private static void DFSForReverseGraph(int[][] graph, boolean[] visitedVertices, List<Integer> list, int vertex) {
        visitedVertices[vertex] = true;
        list.add(vertex);

        for (Integer adjacentVertex : getAdjacentVertices(graph, vertex)) {
            if (!visitedVertices[adjacentVertex]) {
                DFSForReverseGraph(graph, visitedVertices, list, adjacentVertex);
            }
        }

    }

    private static List<Integer> getAdjacentVertices(int[][] graph, int source) {
        List<Integer> adjacentVertices = new ArrayList<>();

        for (int vertex = 0; vertex < graph.length; vertex++) {
            if (graph[source][vertex] == 1) {
                adjacentVertices.add(vertex);
            }
        }

        return adjacentVertices;
    }

    private static int[][] getReverseGraph(int[][] graph) {
        int[][] reverseGraph = new int[graph.length][graph.length];

        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[row].length; col++) {

                if (graph[row][col] == 1) {
                    reverseGraph[col][row] = 1;
                }
            }
        }

        return reverseGraph;
    }
} 

class User {
    
        String FirstName;
        String LastName;
        int Age;
        String Gender;
        String Sns;
        String Email;
        String Identifier;
        
	public User(String FirstName, String LastName,int Age, String Gender, String Sns, String Email) {
		/*
		 * Pattern is id|name|bday|age|course
		 */

		// initializer our tokenizer
		
		// set the values
		this.setFirstName(FirstName);
                this.setLastName(LastName);
		this.setAge(Age);
		this.setGender(Gender);
		this.setSns(Sns);
		this.setEmail(Email);
                this.setIdentifier();
	}
        
        public User(String FirstName, String LastName,int Age, String Gender, String Sns, String Email, String Identifier) {
		/*
		 * Pattern is id|name|bday|age|course
		 */

		// initializer our tokenizer
		
		// set the values
		this.setFirstName(FirstName);
                this.setLastName(LastName);
		this.setAge(Age);
		this.setGender(Gender);
		this.setSns(Sns);
		this.setEmail(Email);
                this.setIdentifier(Identifier);
	}

	public User() {
		super();
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}


	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}

	

	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	public String getSns() {
		return Sns;
	}

	public void setSns(String Sns) {
		this.Sns = Sns;
	}
        public String getEmail() {
		return Sns;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
        
        public String getIdentifier() {
		return Identifier;
	}

	public void setIdentifier() {
		this.Identifier = UUID.randomUUID().toString();
                this.Identifier = this.Identifier.substring(0, 12).replace("-", "").toString();
	}
        
        public void setIdentifier(String Idnetifier) {
		this.Identifier = Idnetifier;
	}
	


}



