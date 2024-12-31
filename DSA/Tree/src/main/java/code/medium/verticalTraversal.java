package code.medium;

import code.TreeNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.Position;
import java.util.*;

public class verticalTraversal {
    @Getter
    @Setter
    class Position {
        int level;
        int row;

        public Position(int level, int row) {
            this.level = level;
            this.row = row;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // Check reference equality
            if (obj == null || getClass() != obj.getClass()) return false; // Check class type
            Position position = (Position) obj; // Cast to Position
            return level == position.level && row == position.row; // Compare fields
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, row);
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return null;
    }
}
