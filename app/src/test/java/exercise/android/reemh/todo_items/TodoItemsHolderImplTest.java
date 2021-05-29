//package exercise.android.reemh.todo_items;
//
//import junit.framework.TestCase;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class TodoItemsHolderImplTest {
//  @Test
//  public void when_addingTodoItem_then_callingListShouldHaveThisItem(){
//    // setup
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//
//    // verify
//    Assert.assertEquals(1, holderUnderTest.getCurrentItems().size());
//  }
//
//  @Test
//  public void when_onCreate_then_statusIsInprogress(){
//    // setup
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//
//    // verify
//    Assert.assertEquals("In progress", holderUnderTest.getCurrentItems().get(0).getState());
//  }
//  @Test
//  public void when_clickingDone_then_stateIsDone(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.getCurrentItems().get(0).switch_state();
//    // verify
//    Assert.assertEquals("Done", holderUnderTest.getCurrentItems().get(0).getState());
//  }
//  @Test
//  public void when_adding3Items_then_sizeis3(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.addNewInProgressItem("cut grass");
//
//    // verify
//    Assert.assertEquals(3, holderUnderTest.getCurrentItems().size());
//  }
//  @Test
//  public void when_adding3Itemsdel2_then_sizeis1(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.addNewInProgressItem("cut grass");
//    holderUnderTest.deleteItem(holderUnderTest.getCurrentItems().get(0));
//    holderUnderTest.deleteItem(holderUnderTest.getCurrentItems().get(0));
//
//    // verify
//    Assert.assertEquals(1, holderUnderTest.getCurrentItems().size());
//  }
//
//  @Test
//  public void when_adding10items_then_sizeis10andrecyclerworks(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.addNewInProgressItem("cut grass");
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.addNewInProgressItem("cut grass");
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.addNewInProgressItem("cut grass");
//    holderUnderTest.addNewInProgressItem("do shopping");
//
//    // verify
//    Assert.assertEquals(10, holderUnderTest.getCurrentItems().size());
//  }
//  @Test
//  public void when_addingandelete_then_sizeis1(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.deleteItem(holderUnderTest.getCurrentItems().get(0));
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.deleteItem(holderUnderTest.getCurrentItems().get(0));
//    holderUnderTest.addNewInProgressItem("cut grass");
//
//
//    // verify
//    Assert.assertEquals(1, holderUnderTest.getCurrentItems().size());
//  }
//  @Test
//  public void when_switchingOnlypartStatus_then_onlyPartChange(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.getCurrentItems().get(0).switch_state();
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.addNewInProgressItem("cut grass");
//    holderUnderTest.getCurrentItems().get(2).switch_state();
//
//
//    // verify
//    Assert.assertEquals("Done", holderUnderTest.getCurrentItems().get(0).getState());
//    Assert.assertEquals("In progress", holderUnderTest.getCurrentItems().get(1).getState());
//    Assert.assertEquals("Done", holderUnderTest.getCurrentItems().get(2).getState());
//
//  }
//  @Test
//  public void when_switchingback_then_statusDoesntchange(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.getCurrentItems().get(0).switch_state();
//    holderUnderTest.getCurrentItems().get(0).switch_state();
//
//    // verify
//    Assert.assertEquals("In progress", holderUnderTest.getCurrentItems().get(0).getState());
//
//  }
//
//  @Test
//  public void when_adding_then_orderIsCorrect(){
//    TodoItemsHolderImpl holderUnderTest = new TodoItemsHolderImpl();
//    Assert.assertEquals(0, holderUnderTest.getCurrentItems().size());
//
//    // test
//    holderUnderTest.addNewInProgressItem("do shopping");
//    holderUnderTest.addNewInProgressItem("fix sink");
//    holderUnderTest.addNewInProgressItem("cut grass");
//
//
//    // verify
//    Assert.assertEquals("do shopping", holderUnderTest.getCurrentItems().get(0).getDesc());
//
//  }
//  // TODO: add at least 10 more tests to verify correct behavior of your implementation of `TodoItemsHolderImpl` class
//}