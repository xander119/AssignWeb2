<%@ include file="header.jsp"%>


<div class="details">
	<div class="product-details">
		<img alt="" src="">
		<div class="desc span_3_of_2">
			<h2>
				<s:property value="item.title" />
			</h2>
			<img alt="" src="C:/JBOSS/jboss-as-7.1.1.Final/standalone/deployments/userimages/<s:property value="item.image"/>">
			<p>
				Manufacture :
				<s:property value="item.manufacturer" />
			</p>
			<div class="price">
				<p>
					Price: <span><s:property value="item.price" /></span>
				</p>
			</div>
			Available in stock:
			<s:property value="item.stockQuantity" />
			<s:if test="#session.customer!=null">
			<div class="available">
				<s:form action="addToCart">
					<p>Available Options :</p>
					<s:hidden value="%{item.id}" name="itemId"></s:hidden>
					<s:textfield type="number" label="Quantity" name="quantity"></s:textfield>
					<span><s:submit type="button">Add to Cart</s:submit></span>
				</s:form>
				<div class="clear"></div>


			</div>
			<div class="clear"></div>
			</s:if>
		</div>
		<s:if test="#session.customer!=null">
		
		<div class="product_desc">
			<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
				<div class="resp-tab-item" aria-controls="tab_item-2" role="tab">Product Reviews</div>
				<div class="clear"></div>
				<h2>Product Reviews</h2>
				<div>
					<s:iterator value="reviews">
						<h4>
							Review by <s:property value="customer.userName"/>
						</h4>
						Rate : <s:property value="rate"/>
						Review : <s:property value ="content" />
					</s:iterator>
					<div>
						<h3>How Do You Rate This Product?</h3>
						<p>Write Your Own Review?</p>
						<s:form action="submitReview"  theme="bootstrap" >
								
								<s:select label="Rate" name="review.rate" headerKey="-1" headerValue="Select Rate"
									list="#{'01':'1', '02':'2', '03':'3', '04':'4', '05':'5'}" />
								<div>
								<span><label>Review<span class="red">*</span></label></span>
								<span>
								<s:hidden name="itemId" value="%{item.id}"/>
								<s:textarea cols="50" rows="20" name="review.content"></s:textarea>
								</span>
							</div>
								<span><s:submit type="button" value="SUBMIT REVIEW" /></span>
						</s:form>
					</div>
				</div>
			</div>
		</div>
		</s:if>
	</div>


</div>

</body>
</html>