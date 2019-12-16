package shapes;
public interface Selectable {
   public boolean getSelected();
   public void setSelected( boolean select);
   public Shape contains(int x, int y);
}