//"  hello world" -> "    helloworld"

static void moveSpaceInFront(char str[]) 
{ 
    // Keep copying non-space characters 
    int i = str.length-1; 
      
    for (int j = i; j >= 0; j--) 
        if (str[j] != ' ') 
            str[i--] = str[j]; 
  
    // Move spaces to be beginning 
    while (i >= 0) 
        str[i--] = ' '; 
} 

    static void moveSpaceInFront(char str[])  
    {  
        // Traverse from end and swap spaces  
        int i = str.length-1;  
        for (int j = i; j >= 0; j--)  
            if (str[j] != ' ') 
            { 
                char c = str[i]; 
                str[i] = str[j]; 
                str[j] = c; 
                i--; 
            } 
    }  
