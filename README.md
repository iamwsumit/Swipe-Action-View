# Swipe-Action-View

This extension allows you to make your views or layout swipeable with [Swipe View](https://github.com/daimajia/AndroidSwipeLayout) library. With this extension you can implmemnt swipe in arrangement and in dynamic arrangement. Some demos are given in preview section and you can check the given demo apk. 

Let's see its blocks and their documnetation.

## All Blocks

![blocks (12)](https://user-images.githubusercontent.com/74917290/129307598-fff56922-6c26-468b-b306-a17531d11ac0.png)

## Documnetation

![component_event](https://user-images.githubusercontent.com/74917290/129307646-3723a81a-2d61-45a8-8d36-d8823f31990b.png)

This event raises when the surface view is swiped full.

![component_event (1)](https://user-images.githubusercontent.com/74917290/129307681-f92d1ace-4a59-4d5d-ab0b-fa5566849ab8.png)

This event raises when user releasd its hand from the surface view.

![component_event (2)](https://user-images.githubusercontent.com/74917290/129307719-9f958b9f-aa07-4aca-b6ca-d0dc8804aa64.png)

This event raises when user swiping your view(not opened fully nor closed fully). It returns horizontal offset in x variabe and vertical offset in y variable.

![component_event (3)](https://user-images.githubusercontent.com/74917290/129307817-8f2c4e8e-83a7-4744-8503-6d821c036928.png)

This event raises when surface view is visible fully in UI or background view has been slided and closed.

![component_method (4)](https://user-images.githubusercontent.com/74917290/129307910-22a8ae2a-82de-457d-82e3-bcc0aeee5a14.png)

This block do the main job that is to create the swipe layout. It is a type of fram layout just has some swipeable functions. You have to give a unique id so you can use it later to add the views and customising it. Give the container in which you want to create this layout to in parameter. surfaceView parameter accept the main layout that will be shown frontly. clicktoClose paramter accept a boolean value if given true then when user click bakcground views then it will be closed autimatically.

![component_method (5)](https://user-images.githubusercontent.com/74917290/129308173-357ed849-1b31-4dcc-a618-d70875bddcf5.png)

This block helps you to enable or disable the swipe in particular direction. There are 4 properties given for defining the direction.

![component_method (6)](https://user-images.githubusercontent.com/74917290/129308254-3187be36-c039-4b5d-b9e7-fdea9339e72d.png)

This block helps you to add the views that will be shown in background or when the surface view is being swiped. You can add one view to one direction and can add four views in four direction. See the Usage for more info.

![component_method (7)](https://user-images.githubusercontent.com/74917290/129308448-86193d52-4bc8-452c-a2a4-4a06be2adef1.png)

This block set the mode of swipe layout. There are two properties given for defining the modes.

![component_method (8)](https://user-images.githubusercontent.com/74917290/129308493-fa3a81ce-779c-4e7b-b629-44e6554688e3.png)

This block return the current applied show mode refrenced to given id.

![component_method (9)](https://user-images.githubusercontent.com/74917290/129308524-406c74a4-dac1-4491-a854-65da23be0860.png)

This block opens or swipe the view in given direction refrenced to given id.

![component_method (10)](https://user-images.githubusercontent.com/74917290/129308564-589a37a5-4669-4924-81dc-ce81a3f37d91.png)

This block close or slide the surface view to its original position.

![image](https://user-images.githubusercontent.com/74917290/129308624-4740e822-eebf-4adf-82a6-de1801c33db4.png)

These are two properties for modes.

![image](https://user-images.githubusercontent.com/74917290/129308661-2c574325-30af-4347-83fc-5cd1c6452238.png)

These are the properties for defining the direction or drag edge.

Hope you understood the documentation.
Let see usage and output now

## Usage

![blocks (13)](https://user-images.githubusercontent.com/74917290/129308758-fe85e1e4-7fbb-4db1-a419-bb70eb37854c.png)

First you have to use this block to create the swipe layout in given container. 

![blocks (14)](https://user-images.githubusercontent.com/74917290/129308815-9e4776f9-117f-4d9b-a612-6653742f5585.png)

After creating the layout layout you need to add the views(min :- 1 and max :- 4) in any direction but one view to one direction.
You just completed the necesarry steps. Now you can change the modes or add the events for listening.

## Preview

Let see output now

### Simple Views

![Simple](https://user-images.githubusercontent.com/74917290/129309725-ff571ca6-7549-47a9-be91-6946643fb4c3.gif)

### Dynamic List

![DynamicList](https://user-images.githubusercontent.com/74917290/129309730-d3b4af19-e5f7-4616-8441-8ec248c77e05.gif)

### Grid View

![grid](https://user-images.githubusercontent.com/74917290/129309732-eb01ffa6-f591-4eca-a448-c0fbcbf81b45.gif)

## Download

Download [APK](https://github.com/Sumit1334/Swipe-Action-View/blob/main/apk/SwipeActionView.apk?raw=true)<br>
Download [Aix](https://github.com/Sumit1334/Swipe-Action-View/blob/main/out/com.sumit1334.swipeactionview.aix?raw=true)

## Donate

If you can donate then [Paypal](https://www.paypal.com/paypalme/sumitdon1) here

## Credit

Thanks to Shreyash for his super Rush .

Suggestion and issue are welcome

If you like the extension then like the topic
Thank You All
