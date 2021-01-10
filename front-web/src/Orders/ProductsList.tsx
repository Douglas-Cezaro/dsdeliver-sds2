import { checkIsSelected } from "./helpers";
import ProductsCard from "./ProductCard";
import { Product } from "./types";

type Props = {
  products: Product[];
  onSelectProduct: (product: Product) => void;
  selectedProducts: Product[];
};

export default function ProductsList({
  products,
  onSelectProduct,
  selectedProducts,
}: Props) {
  return (
    <div className="orders-list-container">
      <div className="orders-list-items">
        {products.map((product) => (
          <ProductsCard
            product={product}
            key={product.id}
            onSelectProduct={onSelectProduct}
            isSelected={checkIsSelected(selectedProducts, product)}
          />
        ))}
      </div>
    </div>
  );
}
