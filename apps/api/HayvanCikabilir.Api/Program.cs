using HayvanCikabilir.Api.Infrastructure.Persistence;
using HayvanCikabilir.Api.Modules.Identity.Domain;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddDbContext<AppDbContext>(options =>
{
    options.UseNpgsql(
        builder.Configuration.GetConnectionString("Postgres"));
});

builder.Services
    .AddIdentityApiEndpoints<ApplicationUser>()
    .AddEntityFrameworkStores<AppDbContext>();

builder.Services.AddAuthorization();
builder.Services.AddOpenApi();

var app = builder.Build();

app.UseAuthentication();
app.UseAuthorization();

if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();

app.MapGroup("/api/auth")
    .MapIdentityApi<ApplicationUser>();

app.MapGet("/api/health/database",
    async (
        AppDbContext dbContext,
        CancellationToken cancellationToken) =>
    {
        var canConnect =
            await dbContext.Database.CanConnectAsync(cancellationToken);

        return canConnect
            ? Results.Ok(new
            {
                status = "ok",
                database = "postgresql"
            })
            : Results.Problem("PostgreSQL bağlantısı kurulamadı.");
    });

app.Run();