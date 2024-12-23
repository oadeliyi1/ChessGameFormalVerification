Original Source Code and Chess Game Directly Taken From: https://github.com/minimonomana/Chess_Game?tab=readme-ov-file


# ChessGameFormalVerification
To formal verification of the chess game, you need to have JBMC installed and following the pattern as below:
 ```
& "PATHTO JBMC\jbmc.exe" --classpath "PATHTO TEST FILE AFTER COMPILING\\ChessGameFormalVerification\out\production\Chess_Game2" pieces.PawnTest
 ```
Example path:
 ```
& "C:\Program Files\cbmc\bin\jbmc.exe" --classpath "C:\Users\Yonghan Xie\Desktop\verification project\ChessGameFormalVerification\out\production\Chess_Game2" pieces.PawnTest
```
# ChessGameFormalVerification
For spot bugs, you need to have SpotBugs extension installed in your IDE and And click run:
![image](https://github.com/user-attachments/assets/cdca4d36-8393-4bf7-8a00-5c58c5c1772f) 
![image](https://github.com/user-attachments/assets/971ad2ea-366e-4bf1-96dd-b53297af229b)
