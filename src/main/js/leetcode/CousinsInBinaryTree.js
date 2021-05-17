function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

/**
 * 判断是否为堂兄弟，有两个条件需要满足
 * <p>
 *     1、深度相同
 *     2、父亲节点是同一个节点
 * </p>
 *
 * @param root
 * @param x
 * @param y
 * @returns {boolean}
 */
var isCousins = function(root, x, y) {
   let x_dept = 0, x_parent = null, x_found = false;
   let y_dept = 0, y_parent = null, y_found = false;

    const dfs = function (node, dept, parent) {
        if (!node) {
            return;
        }
        if (node.val === x) {
            [x_parent, x_dept, x_found] = [parent, dept, true];
        } else if (node.val === y) {
            [y_parent, y_dept, y_found] = [parent, dept, true];
        }

        dfs(node.left, dept + 1, node);

        if (x_found && y_found) {
            return;
        }

        dfs(node.right, dept + 1, node);
    };

    dfs(root, 0, null);
    return x_dept === y_dept && x_parent !== y_parent
};
