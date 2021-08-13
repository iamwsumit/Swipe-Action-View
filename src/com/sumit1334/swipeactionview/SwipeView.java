package com.sumit1334.swipeactionview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;

import java.util.HashMap;

public class SwipeView extends AndroidNonvisibleComponent implements Component {
  private final Context context;
  private final HashMap<String, SwipeLayout> layouts=new HashMap<>();
  private final HashMap<String,View> mainViews=new HashMap<>();
  public SwipeView(ComponentContainer container) {
    super(container.$form());
    this.context= container.$context();
  }
  @SimpleEvent
  public void Closed(String id){
    EventDispatcher.dispatchEvent(this,"Closed",id);
  }
  @SimpleEvent
  public void Swiping(String id,int x,int y){
    EventDispatcher.dispatchEvent(this,"Swiping",id,x,y);
  }
  @SimpleEvent
  public void Opened(String id){
    EventDispatcher.dispatchEvent(this,"Opened",id);
  }
  @SimpleEvent
  public void Released(String id){
    EventDispatcher.dispatchEvent(this,"Released",id);
  }
  @SimpleFunction
  public void Create(final String id,HVArrangement in,AndroidViewComponent surfaceView,boolean clickToClose){
    if (this.layouts.containsKey(id))
      throw new YailRuntimeError("ID is already exist","Duplicate id");
    else {
      final SwipeLayout layout = new SwipeLayout(this.context);
      layout.setLayoutParams(new FrameLayout.LayoutParams(-1,-1));
      ((LinearLayout) ((ViewGroup) in.getView()).getChildAt(0)).addView(layout);
      this.layouts.put(id,layout);
      layout.setClickToClose(clickToClose);
      View mainView = surfaceView.getView();
      ((ViewGroup) mainView.getParent()).removeView(mainView);
      this.mainViews.put(id,mainView);
      layout.addView(mainView);
      layout.addSwipeListener(new SwipeLayout.SwipeListener() {
        @Override
        public void onStartOpen(SwipeLayout layout) {

        }

        @Override
        public void onOpen(SwipeLayout layout) {
          Opened(id);
        }

        @Override
        public void onStartClose(SwipeLayout layout) {

        }

        @Override
        public void onClose(SwipeLayout layout) {
          Closed(id);
        }

        @Override
        public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
          Swiping(id,leftOffset,topOffset);
        }

        @Override
        public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
          Released(id);
        }
      });
    }
  }
  @SimpleFunction
  public void SetSwipingEnabled(String id,String direction,boolean enabled){
    if (this.isExist(id)){
      SwipeLayout layout=this.layouts.get(id);
      if (direction.equals(Left()))
        layout.setLeftSwipeEnabled(enabled);
      else if (direction.equals(Right()))
        layout.setRightSwipeEnabled(enabled);
      else if (direction.equals(Top()))
        layout.setTopSwipeEnabled(enabled);
      else if (direction.equals(Bottom()))
        layout.setBottomSwipeEnabled(enabled);
    }
  }
  @SimpleFunction
  public void Open(String id,String direction){
    if (this.isExist(id)){
      SwipeLayout layout=this.layouts.get(id);
      if (direction.equals(Left()))
        layout.open(true,SwipeLayout.DragEdge.Left);
      else if (direction.equals(Right()))
        layout.open(true,SwipeLayout.DragEdge.Right);
      else if (direction.equals(Bottom()))
        layout.open(true,SwipeLayout.DragEdge.Bottom);
      else if (direction.equals(Top()))
        layout.open(true,SwipeLayout.DragEdge.Top);
      else
        throw new YailRuntimeError("Invalid Direction","Invalid Direction");
    }
  }
  @SimpleFunction
  public void Close(String id){
    if (this.isExist(id))
      this.layouts.get(id).close(true);
  }
  @SimpleFunction
  public void AddView(String id,String direction,AndroidViewComponent view){
    if (this.isExist(id)){
      SwipeLayout layout=this.layouts.get(id);
      View child=view.getView();
      ViewGroup viewGroup=((ViewGroup) child.getParent());
      if (viewGroup!=null)
        viewGroup.removeView(child);
      layout.addView(child);
      if (direction.equals(Left()))
        layout.addDrag(SwipeLayout.DragEdge.Left,child);
      else if (direction.equals(Right()))
        layout.addDrag(SwipeLayout.DragEdge.Right,child);
      else if (direction.equals(Top()))
        layout.addDrag(SwipeLayout.DragEdge.Top,child);
      else
        layout.addDrag(SwipeLayout.DragEdge.Bottom,child);
      ((ViewGroup) this.mainViews.get(id).getParent()).removeView(this.mainViews.get(id));
      layout.addView(this.mainViews.get(id));
    }
  }
  @SimpleFunction
  public int GetShowMode(String id){
    return (this.layouts.get(id).getShowMode() == SwipeLayout.ShowMode.LayDown) ? 2 : 1;
  }
  @SimpleFunction
  public void SetShowMode(String id,int mode){
    if (this.isExist(id))
      this.layouts.get(id).setShowMode(mode == 1 ? SwipeLayout.ShowMode.PullOut : SwipeLayout.ShowMode.LayDown);
  }
  @SimpleProperty
  public int PullOut(){
    return 1;
  }
  @SimpleProperty
  public int LayDown(){
    return 2;
  }
  @SimpleProperty
  public String Left(){
    return "left";
  }
  @SimpleProperty
  public String Top(){
    return "top";
  }
  @SimpleProperty
  public String Bottom(){
    return "bottom";
  }
  @SimpleProperty
  public String Right(){
    return "right";
  }
  private boolean isExist(String id){
    if (this.layouts.containsKey(id))
      return true;
    else
      throw new YailRuntimeError("ID does not exist","ID does not exist");
  }
}
