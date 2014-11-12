##Material design Floating Action Button

Small chunk of code that enables you to use Floating Action Bar

![Alt text](http://i.imgur.com/hk3x2Uz.gif)

As you can see on example above, it gives you possability to use any View you want.

It takes only few steps:

####1. Add xml component in your layout file
   
>        <rs.webnet.floatingactionbutton.FloatingActionButton
>          android:id="@+id/fab"
>          android:layout_width="wrap_content"
>          android:layout_height="wrap_content"/> 
  Place it where you want on the screen. According to google, it's place is in right bottom corner.

####2. Reference FloatingActionButton in your activity
  >
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);

####3. Setup parameters you want

>        fab.setDimmedBackgroundColor("#ddFFFFFF");
>        fab.setIconOpened(R.drawable.ic_fab_opened);
>        fab.setIconClosed(R.drawable.ic_fab_closed);
>        fab.setButtonBackground(R.drawable.ic_fab_bgd_opened);
>        fab.setRotationAngle(450);
>        fab.setAnimationSpeed(300);
        
####4. Add views you want to FAB
  
>        for(int i=0;i<5;i++) {
>            LayoutInflater inflater = getLayoutInflater();
>            View item = inflater.inflate(R.layout.item,null);
>            TextView textView = (TextView) item.findViewById(R.id.name);
>            textView.setText("Call User "+i);
>            fab.addItem(item);
>        }
>
>        ImageView imageView = new ImageView(this);
>        imageView.setImageResource(R.drawable.ic_launcher);
>        fab.addItem(imageView);


#### 5. Enjoy!


It can't be simpler than this!
