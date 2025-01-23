package code.medium;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int asteroid : asteroids) {
            if(stk.isEmpty()) {
                stk.push(asteroid);
            }else{
                int top = stk.peek();
                if(top > 0 && asteroid > 0 && top <= asteroid) stk.push(asteroid);
                else if(top > 0 && asteroid > 0 && top > asteroid); // do nothing;

                else if(top < 0 && asteroid < 0 && Math.abs(top) >= Math.abs(asteroid)) stk.push(asteroid);
                else if(top < 0 && asteroid < 0 && Math.abs(top) < Math.abs(asteroid)) {stk.pop(); stk.push(asteroid);}

                else if((top > 0 && asteroid < 0)){
                    if(Math.abs(top) < Math.abs(asteroid)) {stk.pop(); stk.push(asteroid);}
                    else if(Math.abs(top) == Math.abs(asteroid)) stk.pop();
                }
                else{stk.push(asteroid);}
            }
        }
        int[] remainingAsteroids = new int[stk.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = stk.peek();
            stk.pop();
        }

        return remainingAsteroids;
    }

}
