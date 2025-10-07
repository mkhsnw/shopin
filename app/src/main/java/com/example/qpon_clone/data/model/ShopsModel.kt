import com.example.qpon_clone.data.model.Product
import com.example.qpon_clone.data.model.User

data class Shop(
    val id: Int,
    val name: String,
    val photoUrl: String,
    val address: String,
    val operationalHours: String,
    val distanceDisplay: String
)

data class ShopDetails(
    val shopInfo: Shop,
    val userOwner: User,
    val products: List<Product>
)