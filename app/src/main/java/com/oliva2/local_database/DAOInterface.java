package com.oliva2.local_database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.oliva2.models.BrandModel;
import com.oliva2.models.CategoryDataModel;
import com.oliva2.models.CategoryModel;
import com.oliva2.models.ProductModel;
import com.oliva2.tags.Tags;


import java.util.List;

@Dao
public interface DAOInterface {



    @Insert(entity = ProductModel.class, onConflict = OnConflictStrategy.IGNORE)
    long insertRetrieveData(ProductModel retrieveModel);
    @Insert(entity = CategoryModel.class, onConflict = OnConflictStrategy.IGNORE)
    long insertCategoryData(CategoryModel categoryModelList);
    @Query("SELECT * FROM "+ Tags.table_category)
    List<CategoryModel> getCategory();
    @Query("SELECT * FROM "+ Tags.table_products+" where featured=1 limit :count offset :offest")
    List<ProductModel> getProductByFeatured(int count,int offest );
    @Query("SELECT * FROM "+ Tags.table_products+" where category_id=:id limit :count offset :offest")
    List<ProductModel> getProductByCategory(String id,int count,int offest);
    @Query("SELECT * FROM "+ Tags.table_products+" where brand_id=:id  limit :count offset :offest  ")
    List<ProductModel> getProductByBrand(String id,int count,int offest);
    @Insert(entity = ProductModel.FirstStock.class, onConflict = OnConflictStrategy.IGNORE)
    long insertFirstStockData(ProductModel.FirstStock firstStock);
    @Insert(entity = ProductModel.Tax.class, onConflict = OnConflictStrategy.IGNORE)
    long insertTaxData(ProductModel.Tax tax);

    @Insert(entity = ProductModel.Unit.class, onConflict = OnConflictStrategy.IGNORE)
    long insertUnitData(ProductModel.Unit tax);
    @Insert(entity = ProductModel.OfferProducts.class, onConflict = OnConflictStrategy.IGNORE)
    long[] insertOfferData(List<ProductModel.OfferProducts> retrieveModel);
    @Insert(entity = BrandModel.class, onConflict = OnConflictStrategy.IGNORE)
    long insertBrandData(BrandModel brandModelList);
    @Query("SELECT * FROM "+ Tags.table_brand)
    List<BrandModel> getBrand();
    @Query("SELECT * FROM "+ Tags.table_first_stock+" where product_id=:id")
    ProductModel.FirstStock getProductFirstStock(int id);
    @Query("SELECT * FROM "+ Tags.table_unit+" where product_id=:id")
    ProductModel.Unit getProductunit(int id);
    @Query("SELECT * FROM "+ Tags.table_tax+" where product_id=:id")
    ProductModel.Tax getProductTax(int id);



}