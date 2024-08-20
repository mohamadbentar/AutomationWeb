WinWaitActive("","Authentication Required","10")
WinFlash("", "Authentication Required",4,500)
If WinExists("","Authentication Required") Then
  Send("jkt{TAB}")
  Send("jogja{Enter}")
ElseIf WinExists("","Chrome Legacy Window")Then
  Send("jkt{TAB}")
  Send("jogja{Enter}")
ElseIf WinExists("","Windows Security") Then
  Send("jkt{TAB}")
  Send("jogja{Enter}")
EndIf