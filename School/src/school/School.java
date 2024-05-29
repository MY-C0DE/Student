
package school;
import java.util.Scanner;
class Student{
    String name_st;
    int age;
    int id;
    String type_blood;
    int date_birth;    
}
class SubjectName{
    String name_subject;
    int id_subject;
}
class DegreeStudent{
    int Degree;
    int id_degree;
    int id_student;
    int id_subject;            
}
public class School {
 static int count_student=0;
 static Scanner input=new Scanner(System.in);
 static int size_student;
 static Student [] data_student;
 static int size_subject;
 static SubjectName []name_subject;
 static DegreeStudent[]student_degree;
 static int count_degree=0; 
 
 static void print(Object txt){
     System.out.println(txt);
 }
 static void clean_screen(){
     print("\033[H\033[\2J");
     System.out.flush();
 }
 static void back(){
     print("Click any button to back");
     input.next();
     clean_screen();
 }
 static void show_list() {
        print("1- Add Data  St :");
        print("2- Show Data St : ");
        print("3- search about St : ");
        print("4- update data St : ");
        print("5- Exit : "+ "\n");
    }
 static void add_data(){
     if(count_student <= data_student.length-1){
         Student data=new Student();
          print("Enter name St :");
            data.name_st = input.next();
            print("His/Her Age : ");
            data.age = input.nextInt();
            data.date_birth = 2024 - data.age;           
            print("His/Her  ID : ");
            data.id = input.nextInt();
            print("His/Her  Type blood : ");
            data.type_blood = input.next();
            data_student[count_student] =data;
            count_student++;
      }
     else print("You have added all Student");
 }  
 static int search_index(){    
     print("Enter id");
     int id_search=input.nextInt();
     int find_index=-1;
     for(int i=0;i<count_student;i++){       
      if(id_search==data_student[i].id){
           find_index=i;     
      }
     }
     return find_index;
 }
 static void show_data(){
     int find_index=search_index();
     if(find_index==-1){
         print("Student not Exist");
         back();
     }else{
          print("ID : " + data_student[find_index].id );
            print("Name : " + data_student[find_index].name_st );
            print("Age : " +  data_student[find_index].age );          
            print("Type Blood : " +  data_student[find_index].type_blood );
            print("Date of birth :" +  data_student[find_index].date_birth );
            back();
       }    
 } 
   static void search_student(){
       int find_index=search_index();
       if(find_index==-1){
           print("Student is not Exist");
           back();
       }else { print("Student is Exist");
               back();}  
   }
   static void update_name(){
       int find_index=search_index();
       if(find_index==-1){
           print("Student is not Exist");
           back();
       }else { print("old name : "+ data_student[find_index].name_st);
               print("Enter new name ");
               String new_name=input.next();
               data_student[find_index].name_st=new_name;               
               back();}
   }
   static void update_age(){
        int find_index=search_index();
       if(find_index==-1){
           print("Student is not Exist");
           back();
       }else { print("old name : "+ data_student[find_index].age);
               print("Enter new age ");
               int new_age=input.nextInt();
               data_student[find_index].age=new_age; 
               data_student[find_index].date_birth=2024-data_student[find_index].age;
               back();}
   }
   static void update_id(){
        int find_index=search_index();
       if(find_index==-1){
           print("Student is not Exist");
           back();
       }else { print("old name : "+ data_student[find_index].id);
               print("Enter new id ");
               int new_id=input.nextInt();
               data_student[find_index].id=new_id;               
               back();}
   }
    static void list_update() {
        print("Which wanna update\n"
                + "1- Name \n"
                + "2- Age\n"
                + "3- ID\n"
                + "4- Type blood\n"
                + "5- cansl");
    }
   static void update_typeBlood(){
        int find_index=search_index();
       if(find_index==-1){
           print("Student is not Exist");
           back();
       }else { print("old type blood : "+ data_student[find_index].type_blood);
               print("Enter new type blood ");
               String new_type=input.next();
               data_student[find_index].type_blood=new_type;               
               back();}
   }
   static void do_work(){
       print("(1) Add Subject ");
       print("(2) Add degree of ST");
       print("(3) Show Degree of ST ");
       print("(4) Exit ");
   }
   static void add_sbject(int size){
       name_subject=new SubjectName[size];
    for(int i=0;i<name_subject.length;i++){
        SubjectName addName=new SubjectName();
        addName.name_subject=input.next();
        addName.id_subject=i;
        name_subject[i]=addName;
        }
    back();
   }
   static void add_degree(){
       int find_st=search_index();
       if(find_st==-1)
       print("Student is not Exist");
       else {
           for(int i=0;i<student_degree.length;i++){
               DegreeStudent degree=new DegreeStudent();
               print(name_subject[i].name_subject);
               degree.Degree=input.nextInt();
               degree.id_degree=i;
               degree.id_student=name_subject[i].id_subject;
               degree.id_student= data_student[find_st].id;
               student_degree[count_degree]=degree;
               count_degree++;
           }
       }
       back();
   }
   static void show_degree(){
       int find_index=search_index();
       boolean find=false;
       if(find_index==-1)
       print("Student is not Exist");
       else {
           for(int j=0;j<=1;j++){ find=true;
           print(data_student[find_index].name_st);
           for(int i=0;i<student_degree.length;i++){
               if(student_degree[i].id_student==data_student[find_index].id&&student_degree[i].id_subject==name_subject[i].id_subject)
                 print(name_subject[i].name_subject +" : "+student_degree[i].Degree);
               }
           }
           if(find==false)
               print("We still not but degree");
       }
       back();
   }
   static void ablity_student(){ 
        print("(1) To see your Data ");
        print("(2)To see your Degree");
        print("(3) Exit" + "\n");
   } 
    public static void main(String[] args) {
        print("Welcome ");
        int user; 
        do{
            print("(1) Use app as teacher  " + "\n" + "(2) Use app as student  " + "\n" + "(3) Exit" + "\n");           
            user = input.nextInt();
            switch(user){
                case 1:out:{int flag=1;                 
                    do{show_list();
                       print("First click number one to add st");
                      user=input.nextInt();
                       if(user==1||flag!=1){
                      switch(user){
                          case 1: flag++;
                              if(flag==2){
                                print("How many student do have");
                                 size_student=input.nextInt();
                                 data_student=new Student[size_student];
                                 add_data();
                                 back();
                              }else {add_data();back();}
                              break;
                          case 2:show_data();
                              break;
                          case 3:search_student();
                              break;
                          case 4:
                              do{list_update();
                                user=input.nextInt();
                                switch(user){
                                    case 1:update_name();
                                        break;
                                    case 2:update_age();
                                        break;
                                    case 3:update_id();
                                        break;
                                    case 4:update_typeBlood();
                                        break;
                                    case 5:user=6;
                                        break;
                                    default:print ("just number of list :");
                                }
                              }while(user!=6);
                              break;
                          case 5:
                              break;
                          default:print ("just number of list :");
                      }
                       }
                    }while(user!=5);
                    print("click (1) to continue \nclick any button to get out of user");
                    String users;
                    while(true){
                         users=input.next();
                        if(users.equals("1")){int flags=1;
                           do{do_work();
                             print("First click number one to add  name Subject");
                             user=input.nextInt();
                             if(user==1||flags!=1){
                            switch(user){
                                case 1:flags++;
                                  if(flags==2){
                                  print("How many subject do you have");
                                  size_subject=input.nextInt();
                                  add_sbject(size_subject);
                                  student_degree=new DegreeStudent[(count_student+1)*name_subject.length];
                                  }else add_sbject(size_subject);                                 
                                    break;
                                case 2:add_degree();
                                    break;
                                case 3:show_degree();
                                    break;
                                case 4:
                                    break;
                                default:print ("just number of list :");
                            }
                             }
                           }while(user!=4); 
                        }else break out;
                        if(user==4)
                            break;
                    }
                }//out
                    break;
                case 2:String use;
                    do{
                    ablity_student();
                    use=input.next();
                    switch(use){
                        case "1":show_data();
                            break;
                        case "2":show_degree();
                            break;
                        case "3":
                            break;
                        default:print ("just number of list :");
                    }
                }while(!use.equalsIgnoreCase("3"));
                    break;
                case 3:
                    print("Have a good time");
                    break;
                default:print("just number of list");
            }
        }while(user!=3);
    }    
}
