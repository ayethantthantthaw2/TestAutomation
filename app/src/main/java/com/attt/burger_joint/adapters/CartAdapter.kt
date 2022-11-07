import android.view.LayoutInflater
import android.view.ViewGroup
import com.attt.burger_joint.R
import com.attt.burger_joint.adapters.BaseRecyclerAdapter
import com.attt.burger_joint.data.vos.BurgerVO
import com.attt.burger_joint.delegates.CartViewHolderActionDelegate
import com.attt.burger_joint.viewholders.CartViewHolder


class CartAdapter(private val mDelegate: CartViewHolderActionDelegate) :
    BaseRecyclerAdapter<CartViewHolder, BurgerVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_item_cart, parent, false)
        return CartViewHolder(view, mDelegate)
    }
}

