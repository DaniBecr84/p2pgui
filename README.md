p2pgui
======

P2PGUI is a GUI front-end based on Kos' [P2PADB Framework](https://github.com/kosborn/p2p-adb)

#What is p2pgui?

p2pgui is an app based on Kos' p2padb framework. The app itself is self containted except for Kos' Lockscreen bypass app
(antiguard.apk and installanti.sh). 

#What does it do?

p2pgui allows you to connect two via [USB OTG Cable](http://hakshop.myshopify.com/products/micro-to-micro-otg)
and execute comands on the victim phone via ADB. Commands available:

1. Steal Photos --> This command uses adb to pull all files from the victim phones /sdcard/DCIM/Camera and put them in a
folder called /sdcard/victim_photos on your phone.

2. Steal Data --> This command uses adb to pull all files from the victim phone's /sdcard/data folder and put them in
a folder called /sdcard/victim_data on your phone

3. Bypass Lockscreen --> This command uses installAnti.sh to install and run AntiGuard.apk (thanks to Kos) which bypasses
the lock screen on the victim phone.


#Requirements

   1. Attack Phone (Your Phone) needs ADB, Root, and OTG support
   2. [USB OTG (On The Go) Cable](http://hakshop.myshopify.com/products/micro-to-micro-otg)
   3. Victim Phone needs ADB Running (Most custom ROMS leave it on by default, some times it's on from the carier too)

#Tested Against

  1. CM9/10/10.1
  2. AOKP ICS/JB
  3. AOSP Stock ICS/JB


#Credits
Note: If you're looking to report a bug, please use the issue tracker in GitHub. Support can also be found that way. 

Thanks to [@thekos](https://twitter.com/#!/thekos) for his original idea [p2p-adb](https://github.com/kosborn/p2p-adb)

x942 (me) for p2pgui app
