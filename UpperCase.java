public class UpperCase implements Command {
    @Override
    public String transform(String targetLine) {
       try {
            String holder = targetLine.replaceAll("[^A-Za-z]+", " ");
            holder = holder.toUpperCase();
            return holder;
        } catch (NullPointerException e){
            return "no more lines ";
        }
    }
}
