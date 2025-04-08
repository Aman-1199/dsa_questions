class maxlensub
{
    public static void main(String []args)
    {
        int arr[]={1,1,1,2,3,5};
        slide(arr);

    }
    static void slide(int arr[])
    {
        int len=arr.length;
        int l=0;
        int r=0;
        int sum=0;
        int maxlen=-1;
        while(r<len)
        {
            sum+=arr[r];
            if(sum==5)
            {
                maxlen=Math.max(maxlen,(r-l+1));
            }
            else if(sum>5)
            {
                sum-=arr[l];
                l++;
            }
            r++;
        }
        System.out.println(maxlen);
    }
}